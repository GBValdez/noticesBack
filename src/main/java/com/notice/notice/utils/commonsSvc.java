package com.notice.notice.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class commonsSvc <E extends  baseModel,R extends JpaRepository<E,Long>>{
    protected final R repository;

    public E save(E entity){
        entity.setUpdateAt(new Date());
        return repository.save(entity);
    }
    public List<E> findAll(){
        return repository.findAll();
    }
    public E findById(Long id){
        return repository.findById(id).orElse(null);
    }
    public boolean delete(E item){
        item.setDeleteAt(new Date());
        repository.save(item);
        return true;
    }

}
