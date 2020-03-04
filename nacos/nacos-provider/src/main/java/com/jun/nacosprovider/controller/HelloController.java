package com.jun.nacosprovider.controller;

import com.alibaba.fastjson.JSON;
import com.jun.nacosprovider.entity.User;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);


    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name+ " ,i am from port:" + port;
    }

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

    @PostMapping("/testFile1")
    public String testFile1(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "file:" + file.getOriginalFilename() + " ,i am from port:" + port;
    }
}
