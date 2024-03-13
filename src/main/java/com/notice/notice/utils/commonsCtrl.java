package com.notice.notice.utils;

import com.notice.notice.user.user;
import com.notice.notice.user.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class commonsCtrl <E extends baseModel,R extends JpaRepository<E,Long>,S extends commonsSvc<E, R>>{
    private final S service;
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<E> save(@RequestBody E entity){

        return ResponseEntity.ok(service.save(entity));
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<E> update(@RequestBody E entity){

        return ResponseEntity.ok(service.save(entity));
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity delete(Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable("id") Long id){

        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<E>> findAll(){

           return ResponseEntity.ok(service.findAll());
    }
}
