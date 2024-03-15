package com.notice.notice.notice;

import com.notice.notice.user.user;
import com.notice.notice.user.userSvc;
import com.notice.notice.utils.commonsCtrl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class noticeController extends commonsCtrl<notice,noticeRepository,noticeSvc,noticeDto,noticeCreationDto> {


    public noticeController( noticeSvc service, ModelMapper modelMapper, userSvc userService) {
        super(notice.class, noticeDto.class, service, modelMapper, userService);
    }

    @Override
    protected notice modifyEntityPost(notice entity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user thisUser= userService.findByUsername(authentication.getName()).get();
        entity.setAuthor(thisUser);
        entity.setPublicationDay(new Date());
        return entity;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<noticeDto>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<noticeDto> findById(Long id) {
        return super.findById(id);
    }

    @GetMapping("/findByCategory")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<noticeDto>> findByCategory(@RequestParam List<Long> idsCatalogue) {
        List<noticeDto> notices = modelMapper.map(service.findByCategoriesIn(idsCatalogue), List.class);
        return ResponseEntity.ok(notices);
    }



}
