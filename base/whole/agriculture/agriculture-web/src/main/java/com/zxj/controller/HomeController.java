package com.zxj.controller;

import com.zxj.domain.About;
import com.zxj.domain.Activity;
import com.zxj.domain.Project;
import com.zxj.domain.VolunteerStyle;
import com.zxj.service.IAboutService;
import com.zxj.service.IActivityService;
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


    @Autowired
    private IActivityService activityService;


    @Autowired
    private IVolunteerStyleService volunteerStyleService;


    @GetMapping("/index")
    public String home(Model model) {
        Project project=new Project();
        project.setIspublish(1);
        List<Project> list = projectService.selectProjectHomeList(project);
        model.addAttribute("projects", list);

        // 志愿者
        VolunteerStyle volunteerStyle = new VolunteerStyle();
        volunteerStyle.setIspublish(1);
        List<VolunteerStyle> listV = volunteerStyleService.selectVolunteerStyleList(volunteerStyle);

        if(listV!=null && listV.size()>0){
            model.addAttribute("volunteers", listV);
        }else {
            model.addAttribute("volunteers", null);
        }
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


    /**
     * 惠农风采
     * @return
     */
    @GetMapping("/activity")
    public String activity(Model model) {
        Activity activity = new Activity();
        activity.setIsPublish(1);
       List<Activity> list = activityService.selectActivityList(activity);
        if(list!=null && list.size()>0){
            model.addAttribute("activities", list);
        }else{
            model.addAttribute("activities", null);
        }

        return prefix + "/activity";
    }

    /**
     * 惠农风采
     * @return
     */
    @GetMapping("/activityHistory/{id}")
    public String activityHistory(Model model, @PathVariable("id") Integer id) {
        Activity activity = activityService.selectActivityById(id);
        model.addAttribute("activity", activity);
        return prefix + "/activityHistory";
    }

    /**
     * 惠农风采
     * @return
     */
    @GetMapping("/activityHistory")
    public String activityHistory() {
        return prefix + "/activityHistory";
    }

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
