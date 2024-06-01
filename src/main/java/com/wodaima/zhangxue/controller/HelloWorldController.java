package com.wodaima.zhangxue.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    // 处理 "/api/hello" GET 请求
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!"; // 返回 "Hello, World!"
    }
}
