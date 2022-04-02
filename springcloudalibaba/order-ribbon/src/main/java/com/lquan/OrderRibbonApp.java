package com.lquan;

import com.lquan.ribbon.RibbonRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloudalibaba
 * @description: 启动类
 * @author: lquan
 * @create: 2022-03-31 16:12
 **/

@SpringBootApplication
@RibbonClients(value = {
        @RibbonClient(name ="stock-server",configuration = RibbonRandomRuleConfig.class)

})
public class OrderRibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonApp.class,args);
    }



    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return  restTemplate;
    }
}
