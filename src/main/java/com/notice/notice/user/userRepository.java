package com.notice.notice.user;

import com.notice.notice.utils.commosRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends commosRepo<user, Long> {
    Optional<user> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
