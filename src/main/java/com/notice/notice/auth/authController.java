package com.notice.notice.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class authController {
    private final authSvc autSvc;

    @PostMapping("/login")
    public ResponseEntity<authResponse> login(@RequestBody loginRequest login) {
        return ResponseEntity.ok(autSvc.login(login));
    }

    @PostMapping("/register")
    public ResponseEntity<authResponse> register(@RequestBody registerRequest register) {
        return ResponseEntity.ok(autSvc.register(register));
    }
}
