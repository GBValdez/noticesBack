package com.notice.notice.utils;

import com.notice.notice.user.user;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class commonsSvc <E extends  baseModel,R extends commosRepo<E,Long>>{
    protected final R repository;

    public E save(E entity){
        entity.setUpdateAt(new Date());
        return repository.save(entity);
    }
    public List<E> findAll(){
        return repository.findByDeleteAtIsNull();
    }
    public E findById(Long id){
        E entity= repository.findById(id).orElse(null);
        if(entity!=null  )
            if(entity.getDeleteAt()!=null)
                return null;
        return entity;
    }
    public boolean delete(E item){

        item.setDeleteAt(new Date());
        repository.save(item);
        return true;
    }

}
