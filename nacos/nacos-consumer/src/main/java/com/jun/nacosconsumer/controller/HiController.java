package com.jun.nacosconsumer.controller;

import com.jun.nacosfeign.service.IFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HiController {

    private static Logger log = LoggerFactory.getLogger(HiController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    IFeignClient feignClient;

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
    /**
     * @Author JZxiaoxiao
     * @Description 调用 nacos-feign 的文件上传服务：testFile1
     * @Date 2020/3/4 17:58
     * @Param [file]
     * @return java.lang.String
     */
    @PostMapping(value = "/test4")
    public String testFile1(@RequestParam("file") MultipartFile file) {
        return feignClient.testFile1(file);
    }

    /**
     * @Author JZxiaoxiao
     * @Description 调用 nacos-feign 的文件下载服务，提供字节流：testFile2
     * @Date 2020/3/4 17:58
     * @Param [file]
     * @return java.lang.String
     */
    @PostMapping(value = "/test5")
    public byte[] testFile2(@RequestParam("file") MultipartFile file) {
        byte[] data = feignClient.testFile2(file);
        return data;
    }

    /**
     * @Author JZxiaoxiao
     * @Description 调用 nacos-feign 的文件下载服务，提供字符流：testFile3
     * @Date 2020/3/5 11:43
     * @Param [file]
     * @return java.lang.String
     */
    @PostMapping(value = "/test6")
    public String testFile3(@RequestParam("file") MultipartFile file) {
        String datas = feignClient.testFile3(file);
        return datas;
    }
}
