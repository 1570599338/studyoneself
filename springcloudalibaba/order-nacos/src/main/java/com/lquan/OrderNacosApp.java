package com.lquan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloudalibaba
 * @description: 启动类
 * @author: lquan
 * @create: 2022-03-31 16:12
 **/

@SpringBootApplication
public class OrderNacosApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosApp.class,args);
    }



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return  restTemplate;
    }
}
