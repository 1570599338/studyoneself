package com.zxj.controller.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springs
 * @description: index的controller
 * @author: zxj
 * @create: 2022-01-30 15:47
 **/
@Controller
@RequestMapping("/demoxxxx")
public class DemoControllerTest {
    private String prefix = "/demo/form/";

    @RequestMapping("/jasny")
    public  String index(Model model){


        return prefix+"jasny";
    }



    @RequestMapping("/upload")
    public  String testThymeleaf(Model model){


        return prefix+"upload";
    }




}
