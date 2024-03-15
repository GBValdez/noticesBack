package com.notice.notice.notice;

import com.notice.notice.utils.commonsSvc;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class noticeSvc extends commonsSvc<notice,noticeRepository> {
    public noticeSvc(noticeRepository repository) {
        super(repository);
    }
    // Funcion para buscar las noticias por categorias
    public List<notice> findByCategoriesIn(List<Long> categoryIds){
        return this.repository.findByCategoriesIn(categoryIds);
    }
}
