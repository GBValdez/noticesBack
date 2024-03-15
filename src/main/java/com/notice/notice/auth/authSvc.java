package com.notice.notice.auth;

import com.notice.notice.user.rolSvc;
import com.notice.notice.user.role;
import com.notice.notice.user.user;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.notice.notice.user.userRepository;
import com.notice.notice.jwt.jwtSvc;
import com.notice.notice.auth.loginRequest;
import com.notice.notice.auth.registerRequest;
import com.notice.notice.auth.authResponse;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class authSvc {
    private final userRepository userRepository;
    private final jwtSvc jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final rolSvc roleService;
    public authResponse login(loginRequest loginRequest) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            user user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
            String token = jwtService.getToken(user);
            return new authResponse(token);
        }catch (Exception e){
            return null;
        }

    }

    public authResponse register(registerRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            return null;
        }
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            return null;
        }

        user newUser= modelMapper.map(registerRequest, user.class);
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setUpdateAt(new Date());
        role defaultRole = roleService.findById(2L);
        newUser.getRoles().add(defaultRole);
        newUser=userRepository.save(newUser);
        String token = jwtService.getToken(newUser);
        return new authResponse(token);

    }
}
