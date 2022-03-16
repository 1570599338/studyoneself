package com.zxj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private String prefix = "reception";

    @GetMapping("/index")
    public String home()
    {
        return prefix + "/index";
    }

    @GetMapping("/about")
    public String about()
    {
        return prefix + "/about";
    }


    @GetMapping("/donate")
    public String donate()
    {
        return prefix + "/donate";
    }


}
