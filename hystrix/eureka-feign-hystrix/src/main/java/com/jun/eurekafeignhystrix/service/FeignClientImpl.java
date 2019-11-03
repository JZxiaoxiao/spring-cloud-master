package com.jun.eurekafeignhystrix.service;

import com.alibaba.fastjson.JSON;
import com.jun.eurekafeignhystrix.entity.User;
import org.springframework.stereotype.Component;

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
}
