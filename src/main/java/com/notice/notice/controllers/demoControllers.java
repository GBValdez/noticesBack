package com.jwt.jwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class demoControllers {
    @GetMapping()
    //has la anotacion pre authorize pero con has authorize
    @PreAuthorize("hasAuthority('admin')")
    public String demo(){
        return"demos";
    }
}
