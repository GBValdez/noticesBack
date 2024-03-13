package com.notice.notice.user;

import com.notice.notice.utils.commonsCtrl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notice.notice.utils.errorMesage;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class userController extends commonsCtrl<user,userRepository,userSvc> {
    public userController(userSvc service) {
        super(service);
    }

    @Override
    public ResponseEntity save(user entity) {
        return ResponseEntity.notFound().build();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<user>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<user> findById(Long id) {
        return super.findById(id);
    }
}
