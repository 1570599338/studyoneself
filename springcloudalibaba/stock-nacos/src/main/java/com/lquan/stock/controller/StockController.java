package com.lquan.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloudalibaba
 * @description: 库存订单
 * @author: lquan
 * @create: 2022-03-31 16:08
 **/

@RestController
@RequestMapping("/stock")
public class StockController {


    @Value("${server.port}")
    private String port;

    @RequestMapping("/reduct")
    public  String reduct(){

        return "减库存！"+port;
    }
}

