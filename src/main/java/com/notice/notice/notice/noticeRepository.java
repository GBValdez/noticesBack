package com.notice.notice.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface noticeRepository  extends JpaRepository<notice, Long> {
    @Query("SELECT DISTINCT n FROM Notice n JOIN n.categories nc WHERE nc.id IN :categoryIds")
    List<notice> findByCategoriesIn(List<Integer> categoryIds);
}
