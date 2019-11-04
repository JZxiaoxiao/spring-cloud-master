package com.jun.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope//自动刷新配置文件
@RestController
public class HelloController {

    @Value("${nacos.title:default_value}")
    private String title;


    @GetMapping("/test")
    public String hello() {
        return title;
    }
}
