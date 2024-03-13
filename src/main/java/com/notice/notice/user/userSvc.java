package com.notice.notice.user;

import com.notice.notice.utils.commonsSvc;
import org.springframework.stereotype.Service;

@Service
public class userSvc extends commonsSvc<user, userRepository> {
    public userSvc(userRepository repository) {
        super(repository);
    }
}
