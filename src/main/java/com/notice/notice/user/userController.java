package com.notice.notice.user;

import com.notice.notice.utils.commonsCtrl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notice.notice.utils.errorMesage;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class userController extends commonsCtrl<user,userRepository,userSvc,userDto,userDto> {


    public userController( userSvc service, ModelMapper modelMapper, userSvc userService) {
        super(user.class, userDto.class, service, modelMapper, userService);
    }

    @Override
    public ResponseEntity save(userDto entity, Authentication authentication) {
        errorMesage error=new errorMesage("EndPoint invalido");
        return ResponseEntity.status(403).body(error);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<userDto>> findAll() {
        return super.findAll();
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<userDto> findById(Long id) {
        return super.findById(id);
    }
}
