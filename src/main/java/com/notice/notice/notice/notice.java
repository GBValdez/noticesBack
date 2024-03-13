package com.notice.notice.notice;

import com.notice.notice.category.category;
import com.notice.notice.user.user;
import com.notice.notice.utils.baseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class notice extends baseModel {
    @Column(nullable = false , length = 45)
    String title;
    @Column(nullable = false , length = 100)
    String description;
    @Column(nullable = false , length = 100)
    String imageUrl;
    @Column(nullable = false )
    String body;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    Date publicationDay;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")
    user author;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "notice_categories",
            joinColumns = @JoinColumn(name = "notice_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<category> categories;

}
