package com.example.jekinstest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：TestController
 * @Author: xuli
 * @Date: 2025/9/25 21:38
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String sayHello(String name){
        return "welcome "+name+" to visit my page";
    }
}
