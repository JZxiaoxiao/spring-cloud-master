package com.jun.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo ;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "defaultValue") String name) {
        return "hi " + name + " ,i am from port:" + port +",foo:"+foo;
    }
}
