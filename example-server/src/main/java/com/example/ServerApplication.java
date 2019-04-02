package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


/**
 * 傻瓜监听器
 *
 * @author daFa
 * @EnableEncryptableProperties
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }


}

