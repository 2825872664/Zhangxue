package com.wodaima.zhangxue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZhangxueApplication {

    // 应用程序入口点
    public static void main(String[] args) {
        SpringApplication.run(ZhangxueApplication.class, args); // 运行 Spring Boot 应用程序
    }

    // 配置 RestTemplate Bean
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(); // 创建并返回 RestTemplate 实例
    }

}
