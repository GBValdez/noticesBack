package com.notice.notice.user;

import com.notice.notice.jwt.jwtSvc;
import com.notice.notice.utils.commonsSvc;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userSvc extends commonsSvc<user, userRepository> {
    private jwtSvc jwtService;
    public userSvc(userRepository repository,jwtSvc jwtService) {
        super(repository);
        this.jwtService=jwtService;
    }

    public user findByToken(String token) {
        String userName= jwtService.getUserNameFromToken(token);
        return this.repository.findByUsername(userName).orElse(null);
    }
    public Optional<user> findByUsername(String username){
        return this.repository.findByUsername(username);
    }
}
