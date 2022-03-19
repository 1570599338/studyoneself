package com.zxj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private String prefix = "reception";

    @GetMapping("/index")
    public String home() {
        return prefix + "/index";
    }

    @GetMapping("/about")
    public String about() {
        return prefix + "/about";
    }


    @GetMapping("/donate")
    public String donate() {
        return prefix + "/donate";
    }


    @GetMapping("/event")
    public String event() {
        return prefix + "/event";
    }

    @GetMapping("/event-single")
    public String eventSingle() {
        return prefix + "/event-single";
    }


    @GetMapping("/volunteer")
    public String volunteer() {
        return prefix + "/volunteer";
    }

    @GetMapping("/error")
    public String error() {
        return prefix + "/error";
    }

    @GetMapping("/blog")
    public String blog() {
        return prefix + "/blog";
    }


    @GetMapping("/blog-left")
    public String blogLeft() {
        return prefix + "/blog-left";
    }

    @GetMapping("/blog-fulwidth")
    public String blogFulwidth() {
        return prefix + "/blog-fulwidth";
    }

    @GetMapping("/blog-single")
    public String blogSingle() {
        return prefix + "/blog-single";
    }

    @GetMapping("/blog-single-left")
    public String blogSingleLeft() {
        return prefix + "/blog-single-left";
    }


    @GetMapping("/blog-single-fluid")
    public String blogSingleFluid() {
        return prefix + "/blog-single-fluid";
    }


    @GetMapping("/contact")
    public String contact() {
        return prefix + "/contact";
    }



    @GetMapping("/login")
    public String login() {
        return prefix + "/login";
    }


    @GetMapping("/register")
    public String register() {
        return prefix + "/register";
    }



}
