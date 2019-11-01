package com.jun.eurekafeign.controller;

import com.jun.eurekafeign.service.IFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    IFeignClient feignClient;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return feignClient.sayHiFromClientOne( name );
    }
}