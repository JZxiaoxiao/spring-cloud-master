package com.jun.eurekafeign.service;

import com.jun.eurekafeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-provider")
public interface IFeignClient {
    //
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/say",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    String sayJsonFromClient(@RequestBody User data);

    @RequestMapping(value = "/me",method = RequestMethod.GET)
    String sayJsonStringFromClient(@RequestParam(value = "data") String data);
}
