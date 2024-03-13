package com.notice.notice.utils;

import com.notice.notice.user.user;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class baseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date updateAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteAt;
    @ManyToOne
    user updateUser;

}
