package com.notice.notice.auth;

import com.notice.notice.user.user;
import lombok.RequiredArgsConstructor;
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

@Service
@RequiredArgsConstructor
public class authSvc {
    private final userRepository userRepository;
    private final jwtSvc jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public authResponse login(loginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return new authResponse(token);
    }

    public authResponse register(registerRequest registerRequest) {
        user newUser = user.builder().username(registerRequest.getUsername()).password(passwordEncoder.encode(registerRequest.getPassword())).email(
                registerRequest.getEmail()
        ).updateAt(new Date()).build();
        userRepository.save(newUser);
        return authResponse.builder().token(jwtService.getToken(newUser)).build();

    }
}
