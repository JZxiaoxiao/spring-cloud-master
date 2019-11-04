package com.jun.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerTestApplication.class, args);
    }

}
