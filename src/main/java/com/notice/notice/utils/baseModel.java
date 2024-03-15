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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updateAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteAt;
    @ManyToOne
    @JoinColumn(name = "update_user_id", referencedColumnName = "id", nullable = true)
    private user updateUser;

}
