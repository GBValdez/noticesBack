package com.notice.notice.category;


import com.notice.notice.user.userSvc;
import com.notice.notice.utils.commonsCtrl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@PreAuthorize("isAuthenticated()")

public class categoryController extends commonsCtrl<category,categoryRepository,categorySvc,categoryDto,categoryCreationDto> {
    public categoryController( categorySvc service, ModelMapper modelMapper, userSvc userService) {
        super(category.class, categoryDto.class, service, modelMapper, userService);
    }


/*
    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<categoryDto>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<categoryDto> findById(Long id) {
        return super.findById(id);
    }*/
}
