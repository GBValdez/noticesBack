package com.notice.notice.utils;

import com.notice.notice.user.user;
import com.notice.notice.user.userRepository;

import com.notice.notice.user.userSvc;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class commonsCtrl <E extends baseModel,R extends commosRepo<E,Long>,S extends commonsSvc<E, R>,DTO,DTOCreation>{
    private final Class<E> entityClass;
    private final Class<DTO> dtoClass;
    protected final S service;
    protected final ModelMapper modelMapper;
    protected final userSvc userService;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<E> save(@Valid @RequestBody DTOCreation entity, Authentication authentication){
        E entityMap= modelMapper.map(entity, entityClass);
        entityMap.setUpdateAt(new Date());
        user thisUser= userService.findByUsername(authentication.getName()).get();
        entityMap.setUpdateUser(thisUser);
        entityMap=modifyEntityPost(entityMap,thisUser);

        return ResponseEntity.ok(service.save(entityMap));
    }
    protected E modifyEntityPost(E entity, user userPetition){
        return entity;
    }
    protected errorMesage canDelete(E entity, user userPetition){
        return null;
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<E> update(@Valid @RequestBody DTOCreation entity, @PathVariable("id") long id){
        E oldEntity= service.findById(id);
        if(oldEntity==null)
            return ResponseEntity.notFound().build();
        modelMapper.map(entity, oldEntity);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user thisUser= userService.findByUsername(authentication.getName()).get();
        oldEntity.setUpdateUser(thisUser);
        oldEntity.setId((int) id);
        oldEntity.setUpdateAt(new Date());
        return ResponseEntity.ok(service.save(oldEntity));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity delete(@PathVariable() long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user thisUser= userService.findByUsername(authentication.getName()).get();
        E entity= service.findById(id);
        if(entity==null)
            return ResponseEntity.notFound().build();
        errorMesage error=canDelete(entity,thisUser);
        if(error!=null) {
            return ResponseEntity.badRequest().body(error);
        }
        entity.setUpdateUser(thisUser);
        service.delete(entity);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable("id") Long id){
        E entity= service.findById(id);
        if(entity==null)
            return ResponseEntity.notFound().build();
        DTO dtoMap= modelMapper.map(entity, dtoClass);
        return ResponseEntity.ok(dtoMap);
    }
    @GetMapping
    public ResponseEntity<List<DTO>> findAll(){
        List<DTO> dtoMap= modelMapper.map(service.findAll(), List.class);
           return ResponseEntity.ok(dtoMap);
    }

}
