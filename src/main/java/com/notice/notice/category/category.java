package com.notice.notice.category;

import com.notice.notice.utils.baseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "category")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class category extends baseModel {
    @Column(nullable = false , length = 45)
    String name;
    @Column(nullable = false , length = 100)
    String description;
}
