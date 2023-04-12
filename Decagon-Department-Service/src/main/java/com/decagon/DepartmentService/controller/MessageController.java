package com.decagon.DepartmentService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {
     // Read the values from properties file
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("message")
    public String getMessage(){
        return message;
    }
}
