package com.notice.notice.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class commonsSvc <E extends  baseModel,R extends JpaRepository<E,Long>>{
    private final R repository;

    public E save(E entity){
        entity.updateAt=new Date();
        return repository.save(entity);
    }
    public List<E> findAll(){
        return repository.findAll();
    }
    public E findById(Long id){
        return repository.findById(id).orElseThrow();
    }
    public boolean delete(Long id){
        E item= repository.findById(id).orElseThrow();
        item.setDeleteAt(new Date());
        repository.save(item);
        return true;
    }

}
