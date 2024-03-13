package com.notice.notice.notice;

import com.notice.notice.utils.commonsCtrl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notice")
public class noticeController extends commonsCtrl<notice,noticeRepository,noticeSvc> {
    public noticeController(noticeSvc service) {
        super(service);
    }
}
