package com.notice.notice.notice;

import com.notice.notice.category.categoryDto;
import com.notice.notice.user.userDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class noticeDto {
    int id;
    String title;
    String description;
    String imageUrl;
    String body;
    List<categoryDto> categories;
    String author;
    Date publicationDay;
}
