package com.notice.notice.utils;

import com.notice.notice.notice.notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface commosRepo<E,ID>  extends JpaRepository<E,ID> {
    List<E> findByDeleteAtIsNull();

}
