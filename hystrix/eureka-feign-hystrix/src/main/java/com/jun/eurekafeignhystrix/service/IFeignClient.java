package com.jun.eurekafeignhystrix.service;

import com.jun.eurekafeignhystrix.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "service-provider",fallback = com.jun.eurekafeignhystrix.service.FeignClientImpl.class)
public interface IFeignClient {

    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @PostMapping(value = "/say")
    String sayJsonFromClient(@RequestBody User data);

    //效果等同
//    @RequestMapping(value = "/say",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
//    String sayJsonFromClient(@RequestBody User data);

    @RequestMapping(value = "/me",method = RequestMethod.GET)
    String sayJsonStringFromClient(@RequestParam(value = "data") String data);
}
