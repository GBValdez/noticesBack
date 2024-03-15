package com.notice.notice.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class errorMesage {
    String message;
    public errorMesage(String message){
        this.message = message;
    }
}
