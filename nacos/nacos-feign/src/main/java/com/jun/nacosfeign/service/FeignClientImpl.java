package com.jun.nacosfeign.service;

import com.alibaba.fastjson.JSON;
import com.jun.nacosfeign.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FeignClientImpl implements IFeignClient{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public String sayJsonFromClient(User data) {
        return "sorry "+ JSON.toJSONString(data);
    }

    @Override
    public String sayJsonStringFromClient(String data) {
        return "sorry "+data;
    }

    @Override
    public String testFile1(MultipartFile file) {
        return "sorry "+file.getName();
    }

    @Override
    public byte[] testFile2(MultipartFile file) {
        return new byte[0];
    }
}
