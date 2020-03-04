package com.jun.nacosfeign.service;

import com.jun.nacosfeign.config.MultipartSupportConfig;
import com.jun.nacosfeign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "nacos-provider",configuration = MultipartSupportConfig.class,
        fallback = com.jun.nacosfeign.service.FeignClientImpl.class)
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

    /**
     * @Author JZxiaoxiao
     * @Description 用于远程调用文件上传，注意用@RequestPart
     * @Date 2020/3/4 18:04
     * @Param [file]
     * @return java.lang.String
     */
    @PostMapping(value = "/testFile1",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String testFile1(@RequestPart("file") MultipartFile file);
}
