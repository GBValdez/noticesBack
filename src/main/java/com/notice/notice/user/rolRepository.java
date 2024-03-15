package com.notice.notice.user;

import com.notice.notice.notice.notice;
import com.notice.notice.utils.commosRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface rolRepository extends commosRepo<role, Long> {
    //QUery que verifica si un rol esta asignado a algun usuarios
    @Query(value = "SELECT  count(u.id)>0 FROM users u JOIN users_roles ur ON u.id = ur.user_id WHERE ur.role_id =:id",nativeQuery = true)
    byte existRoleInAnyUser(long id);

}
