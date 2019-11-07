package com.jun.gatewaylimit;

import com.jun.gatewaylimit.filter.HostAddrKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayLimitApplication.class, args);
    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
