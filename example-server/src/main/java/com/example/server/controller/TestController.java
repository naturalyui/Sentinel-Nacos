package com.example.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


/**
 * @author daFa
 * @date 2018/12/7 17:13
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {
    @Value("${spring.application.name}")
    String serverName;

    /**
     *  测试
     */
    @GetMapping("/name")
    public String getApplicationName() {
        return serverName;
    }
}
