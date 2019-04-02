package com.example;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.example.zuul.component.handler.CustomUrlBlockHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author daFa
 */
@EnableFeignClients
//开启zuul网管
@EnableZuulProxy
//整合springboot和熔断注解
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        //设置自定义限流异常
        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
        SpringApplication.run(ZuulApplication.class, args);

    }

}

