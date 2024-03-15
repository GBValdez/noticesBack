package com.notice.notice.utils;

import com.notice.notice.notice.notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
// Repositorio base para los repositorios de las entidades
@NoRepositoryBean
public interface commosRepo<E,ID>  extends JpaRepository<E,ID> {
    // Metodo para obtener todos los registros no borrados
    List<E> findByDeleteAtIsNull();

}
