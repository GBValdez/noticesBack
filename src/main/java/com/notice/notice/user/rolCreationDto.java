package com.notice.notice.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class rolCreationDto {
    @NotBlank(message = "El nombre es requerido")
    @Size( max = 45 , message = "El nombre tiene un maximo de 45 caracteres")
    String name;
    @NotBlank(message = "La descripcion es requerida")
    @Size( max = 100 , message = "La descripcion tiene un maximo de 100 caracteres")
    String description;
}
