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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class commonsCtrl <E extends baseModel,R extends JpaRepository<E,Long>,S extends commonsSvc<E, R>,DTO,DTOCreation>{
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
        entityMap=modifyEntityPost(entityMap);

        return ResponseEntity.ok(service.save(entityMap));
    }
    protected E modifyEntityPost(E entity){
        return entity;
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<E> update(@Valid @RequestBody DTOCreation entity, @PathVariable("id") long id){
        if(service.findById(id)==null)
            return ResponseEntity.notFound().build();
        E entityMap= modelMapper.map(entity, entityClass);
        entityMap.setId((int) id);
        entityMap.setUpdateAt(new Date());
        return ResponseEntity.ok(service.save(entityMap));
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity delete(Long id){
        E entity= service.findById(id);
        if(entity==null)
            return ResponseEntity.notFound().build();
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
