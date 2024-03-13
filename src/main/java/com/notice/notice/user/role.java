package com.notice.notice.user;

import com.notice.notice.utils.baseModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "roles")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class role extends baseModel {
    @Column(nullable = false , length = 45)
    String name;
    @Column(nullable = false , length = 100)
    String description;
}
