package com.lquan.stock.controller;

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

    @RequestMapping("/reduct")
    public  String reduct(){

        return "减库存！";
    }
}

