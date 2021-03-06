package com.jun.eurekafeignhystrix.controller;

import com.alibaba.fastjson.JSON;
import com.jun.eurekafeignhystrix.entity.User;
import com.jun.eurekafeignhystrix.service.IFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControler {

    @Autowired
    IFeignClient feignClient;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return feignClient.sayHiFromClientOne( name );
    }

    @PostMapping(value = "/say")
    public String say(@RequestBody User data) {
        return feignClient.sayJsonFromClient(data);
    }

    @PostMapping(value = "/me")
    public String me(@RequestBody User data) {
        return feignClient.sayJsonStringFromClient(JSON.toJSONString(data));
    }
}