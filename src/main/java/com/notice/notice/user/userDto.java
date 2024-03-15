package com.notice.notice.user;

import lombok.Data;

import java.util.List;

@Data
public class userDto {
    String username;
    String email;
    List<String> roles;
    String name;
}
