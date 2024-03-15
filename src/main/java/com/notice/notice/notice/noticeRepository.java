package com.notice.notice.notice;

import com.notice.notice.category.category;
import com.notice.notice.utils.commosRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface noticeRepository  extends commosRepo<notice, Long> {
    // Query para buscar las notificaciones por categorias
    @Query(value = "SELECT DISTINCT n.* FROM notice n JOIN notice_categories nc ON n.id = nc.notice_id WHERE n.delete_at is null and nc.category_id IN :categories",
        nativeQuery = true
    )
    List<notice> findByCategoriesIn(@Param("categories") List<Long> categories);

}
