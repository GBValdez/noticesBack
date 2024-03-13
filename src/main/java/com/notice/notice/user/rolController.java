package com.notice.notice.user;

import com.notice.notice.utils.commonsCtrl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/rol")
public class rolController extends commonsCtrl<role,rolRepository,rolSvc> {
    public rolController(rolSvc service) {
        super(service);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<role>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<role> findById(Long id) {
        return super.findById(id);
    }
}
