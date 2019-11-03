package com.jun.eurekaproviderhystrix.controller;

import com.alibaba.fastjson.JSON;
import com.jun.eurekaproviderhystrix.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "defaultValue") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @PostMapping("/say")
    public String say(@RequestBody User data) {
        return "data " + JSON.toJSONString(data) + " ,i am from port:" + port;
    }

    @GetMapping("/me")
    public String say(@RequestParam(value = "data") String data) {
        return "data:" + data + " ,i am from port:" + port;
    }
}
