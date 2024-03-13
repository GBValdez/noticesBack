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
    int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date updateAt;
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteAt;
    @ManyToOne
    @JoinColumn(name = "update_user_id", referencedColumnName = "id", nullable = true)
    user updateUser;

}
