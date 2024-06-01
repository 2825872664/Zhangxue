package com.wodaima.zhangxue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // 显示登录页面
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // 返回名为 "login" 的视图模板
    }
}
