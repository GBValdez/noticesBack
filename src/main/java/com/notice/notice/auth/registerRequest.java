package com.notice.notice.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dto para la creacion de un usuario
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class registerRequest {
    @NotBlank(message = "El nombre de usuario es requerido")
    @Size( max = 45 , message = "El nombre de usuario tiene un maximo de 45 caracteres")
    String username;

    @NotBlank(message = "La contraseña es requerida")
    @Size( max = 100 , message = "La contraseña tiene un maximo de 100 caracteres")
    String password;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es valido")
    @Size( max = 100 , message = "El email tiene un maximo de 100 caracteres")
    String email;

    @NotBlank(message = "El nombre es requerido")
    @Size( max = 100 , message = "El nombre tiene un maximo de 100 caracteres")
    String name;
}
