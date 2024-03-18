package com.notice.notice.utils;

import com.notice.notice.user.user;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class baseModel {
    //Clase base para los modelos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    //Este campo representa tanto la fecha de creacion como la fecha de actualizacion,
    //para saber si un registro fue actualizado o no, se debe validar desde la bitacora
    private Date updateAt;
    //Si la fecha de eliminacion no es nula, significa que el registro esta eliminado y
    // no se obtendra al obtener los registros en
    //los servicios de findAll y findById del controlador generico
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteAt;
    //Misma logica que el campo updateAt pero para el usuario que realizo la operacion
    @ManyToOne
    @JoinColumn(name = "update_user_id", referencedColumnName = "id", nullable = true)
    private user updateUser;

}
