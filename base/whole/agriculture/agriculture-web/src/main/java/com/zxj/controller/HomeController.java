package com.zxj.controller;

import com.zxj.domain.About;
import com.zxj.domain.Project;
import com.zxj.domain.VolunteerStyle;
import com.zxj.service.IAboutService;
import com.zxj.service.IProjectService;
import com.zxj.service.IVolunteerStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private String prefix = "reception";

    @Autowired
    private IProjectService projectService;

    @GetMapping("/index")
    public String home(Model model) {
        Project project=new Project();
        List<Project> list = projectService.selectProjectHomeList(project);
        model.addAttribute("projects", list);
        return prefix + "/index";
    }

    // 项目详情
    @RequestMapping("/projectDetail/{id}")
    public String projectDetail(Model model, @PathVariable("id") Integer id) {
        Project project = projectService.selectProjectById(id);
        model.addAttribute("project", project);
        return prefix + "/projectDetail";
    }


    @Autowired
    private IAboutService aboutService;
    @GetMapping("/about")
    public String about(Model model) {

       List<About> list = aboutService.selectAboutList(new About());
       if(list!=null && list.size()>0){
           model.addAttribute("about", list.get(0));
       }else{
           model.addAttribute("about", null);
       }

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

    @Autowired
    private IVolunteerStyleService volunteerStyleService;
    @GetMapping("/volunteer")
    public String volunteer(Model model) {
        VolunteerStyle volunteerStyle = new VolunteerStyle();
        volunteerStyle.setIspublish(1);
        List<VolunteerStyle> list = volunteerStyleService.selectVolunteerStyleList(volunteerStyle);

        if(list!=null && list.size()>0){
            model.addAttribute("volunteers", list);
        }else{
            model.addAttribute("volunteers", null);
        }

        return prefix + "/volunteer";
    }

    // 项目详情
    @RequestMapping("/volunteerDetail/{id}")
    public String volunteerDetail(Model model, @PathVariable("id") Integer id) {
        VolunteerStyle volunteer = volunteerStyleService.selectVolunteerStyleById(id);
        model.addAttribute("volunteer", volunteer);
        return prefix + "/volunteerDetail";
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


    @GetMapping("/alipaySuccess")
    public String alipaySuccess(Model model) {
        model.addAttribute("total_amount", 12);
        return "reception/alipaySuccess";
    }

}
