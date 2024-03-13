package com.notice.notice.notice;

import com.notice.notice.utils.commonsSvc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class noticeSvc extends commonsSvc<notice,noticeRepository> {
    public noticeSvc(noticeRepository repository) {
        super(repository);
    }
}
