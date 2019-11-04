package com.jun.nacosfeign.controller;

import com.alibaba.fastjson.JSON;
import com.jun.nacosfeign.entity.User;
import com.jun.nacosfeign.service.IFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

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
