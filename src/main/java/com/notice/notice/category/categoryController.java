package com.notice.notice.category;


import com.notice.notice.notice.notice;
import com.notice.notice.notice.noticeSvc;
import com.notice.notice.user.user;
import com.notice.notice.user.userSvc;
import com.notice.notice.utils.commonsCtrl;
import com.notice.notice.utils.errorMesage;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@PreAuthorize("isAuthenticated()")

public class categoryController extends commonsCtrl<category,categoryRepository,categorySvc,categoryDto,categoryCreationDto> {
    private final noticeSvc noticeService;
    public categoryController( categorySvc service, ModelMapper modelMapper, userSvc userService,noticeSvc noticeService) {
        super(category.class, categoryDto.class, service, modelMapper, userService);
        this.noticeService=noticeService;
    }



    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<categoryDto>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<categoryDto> findById(Long id) {
        return super.findById(id);
    }

    @Override
    protected errorMesage canDelete(category entity, user userPetition) {
        List<Long> category= new ArrayList<>();
        category.add((long) entity.getId());
        List<notice> notices=noticeService.findByCategoriesIn(category);
        if(notices.size()>0)
            return new errorMesage("No se puede eliminar la categoria, tiene noticias asociadas");
        return null;
    }
}
