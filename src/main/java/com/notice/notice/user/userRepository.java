package com.notice.notice.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<user, Long>{
    Optional<user> findByUsername(String username);
}
