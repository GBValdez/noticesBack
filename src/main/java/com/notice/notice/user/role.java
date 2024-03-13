package com.notice.notice.user;

import com.notice.notice.utils.baseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@Builder
public class role extends baseModel {
    @Column(nullable = false , length = 45)
    String name;
    @Column(nullable = false , length = 100)
    String description;
}
