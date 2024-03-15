package com.notice.notice.notice;

import com.notice.notice.category.category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class noticeCreationDto {
    @NotBlank(message = "El titulo es requerido")
    @Size(  max = 100 , message = "El titulo solo puede tener un maximo de 100 caracteres")
    String title;

    @NotBlank(message = "La descripcion es requerida")
    @Size( max = 100 , message = "La descripcion solo puede tener un maximo de 100 caracteres")
    String description;

    @NotBlank(message = "La imagen es requerida")
    String imageUrl;

    @NotBlank(message = "El cuerpo es requerido")
    String body;

    @NotNull(message = "La categoria es requerida")
    List<Integer> categories;

}
