package com.hong.controller.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springs
 * @description: index的controller
 * @author: hong
 * @create: 2022-01-30 15:47
 **/
@Controller
@RequestMapping("/")
public class IndexControllerTest {
    @RequestMapping("/login")
    public String index(Model model){

        model.addAttribute("name","hello world!!!");
        return "login";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        return "hello world";
    }

    @RequestMapping("/test2")
    public String testThymeleaf(Model model){

        model.addAttribute("name","hello world!!!");
        return "test";
    }

    @RequestMapping("/toLogin")
    public String toLogion(String name, String password){


        try {
            // 获取subject对象
            Subject subject = SecurityUtils.getSubject();
            // 封装登陆用户数据
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name,password);
            //执行登陆方法
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }


        return "test";
    }


    @RequestMapping("/unAuth")
    public String unAuth(Model model){


        return "unAuth";
    }


    @RequestMapping("/add")
    public String add(Model model){

        model.addAttribute("name","add");
        return "add";
    }

    @RequestMapping("/update")
    public String update(Model model){

        model.addAttribute("name","update");
        return "update";
    }



}
