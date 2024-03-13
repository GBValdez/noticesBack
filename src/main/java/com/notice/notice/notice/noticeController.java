package com.notice.notice.notice;

import com.notice.notice.utils.commonsCtrl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class noticeController extends commonsCtrl<notice,noticeRepository,noticeSvc> {
    public noticeController(noticeSvc service) {
        super(service);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<notice>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<notice> findById(Long id) {
        return super.findById(id);
    }
}
