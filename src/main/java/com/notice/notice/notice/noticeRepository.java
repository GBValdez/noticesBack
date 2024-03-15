package com.notice.notice.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface noticeRepository  extends JpaRepository<notice, Long> {
    @Query(value = "SELECT DISTINCT n.* FROM notice n JOIN notice_categories nc ON n.id = nc.notice_id WHERE nc.category_id IN :categories",
        nativeQuery = true
    )
    List<notice> findByCategoriesIn(@Param("categories") List<Long> categories);
}
