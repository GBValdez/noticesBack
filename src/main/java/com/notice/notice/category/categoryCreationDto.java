package com.notice.notice.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class categoryCreationDto {
    @NotBlank(message = "El nombre es requerido")
    @Size( max = 45,message = "El nombre solo puede tener un maximo de 45 caracteres")
    String name;
    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 45,message = "La descripcion solo puede tener un maximo de 100 caracteres")
    String description;
}
