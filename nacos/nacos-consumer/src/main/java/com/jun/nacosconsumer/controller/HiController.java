package com.jun.nacosconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {

    private static Logger log = LoggerFactory.getLogger(HiController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test1")
    public String hello(@RequestParam(value = "name") String name) {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @GetMapping("/test2")
    public String test(@RequestParam(value = "name") String name) {
        String result = restTemplate.getForObject("http://nacos-provider/hello?name="+name, String.class);
        return "Return : " + result;
    }
}
