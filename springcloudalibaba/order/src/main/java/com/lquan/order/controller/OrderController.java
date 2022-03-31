package com.lquan.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloudalibaba
 * @description: 订单
 * @author: lquan
 * @create: 2022-03-31 16:06
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public  String add(){

        String msg = restTemplate.getForObject("http://127.0.0.1:8011/stock/reduct",String.class);

        return "hello world_"+msg;
    }

}
