package com.notice.notice.user;

import com.notice.notice.utils.commonsSvc;
import org.springframework.stereotype.Service;

@Service
public class rolSvc extends commonsSvc<role, rolRepository> {
    public rolSvc(rolRepository repository) {
        super(repository);
    }
}
