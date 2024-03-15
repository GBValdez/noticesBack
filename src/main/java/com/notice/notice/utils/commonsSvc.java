package com.notice.notice.utils;

import com.notice.notice.user.user;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.List;
// Servicio generico para los servicios de la aplicacion
@RequiredArgsConstructor
public class commonsSvc <E extends  baseModel,R extends commosRepo<E,Long>>{
    protected final R repository;

    public E save(E entity){
        entity.setUpdateAt(new Date());
        return repository.save(entity);
    }
    //Metodo para obtener todos los roles no borrados
    public List<E> findAll(){
        return repository.findByDeleteAtIsNull();
    }
    //Metodo para eliminar un registro
    public E findById(Long id){
        E entity= repository.findById(id).orElse(null);
        if(entity!=null  )
            if(entity.getDeleteAt()!=null)
                return null;
        return entity;
    }
    //Metodo para eliminar un registro
    public boolean delete(E item){

        item.setDeleteAt(new Date());
        repository.save(item);
        return true;
    }

}
