package com.notice.notice.user;

import com.notice.notice.utils.commosRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface userRepository extends commosRepo<user, Long> {
    Optional<user> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
}
