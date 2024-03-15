package com.notice.notice.auth;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notice.notice.utils.errorMesage;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class authController {
    private final authSvc autSvc;

    // Metodo para loguear un usuario
    @PostMapping("/login")
    @Operation(summary = "Login",description = "Metodo para loguear un usuario")
    public ResponseEntity<?> login(@RequestBody loginRequest login) {
        authResponse res=autSvc.login(login);
        if(res == null){
            errorMesage error = new errorMesage("Usuario o contraseña incorrectos");
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(res);
    }

    // Metodo para registrar un usuario

    @PostMapping("/register")
    @Operation(summary = "Register",description = "Metodo para registrar un usuario")
    public ResponseEntity<?> register(@RequestBody registerRequest register) {
        authResponse res=autSvc.register(register);
        // Si el usuario no se pudo crear, se envia un mensaje de error
        if(res == null){
            errorMesage error = new errorMesage("Error al crear el usuario");
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok(res);
    }
}
