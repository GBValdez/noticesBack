package com.notice.notice.category;

import com.notice.notice.utils.commonsSvc;
import org.springframework.stereotype.Service;

@Service
public class categorySvc extends commonsSvc<category,categoryRepository> {
    public categorySvc(categoryRepository repository) {
        super(repository);
    }
}
