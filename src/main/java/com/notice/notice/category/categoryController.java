package com.notice.notice.category;


import com.notice.notice.utils.commonsCtrl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@PreAuthorize("isAuthenticated()")

public class categoryController extends commonsCtrl<category,categoryRepository,categorySvc> {
    public categoryController(categorySvc service) {
        super(service);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<category>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<category> findById(Long id) {
        return super.findById(id);
    }
}
