package com.notice.notice.category;


import com.notice.notice.utils.commonsCtrl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class categoryController extends commonsCtrl<category,categoryRepository,categorySvc> {
    public categoryController(categorySvc service) {
        super(service);
    }
}
