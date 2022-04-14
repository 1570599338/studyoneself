package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import com.zxj.common.shiro.ShiroUtils;
import com.zxj.domain.Project;
import com.zxj.domain.VolunteerStyle;
import com.zxj.service.IProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 扶贫项目Controller
 *
 * @author zxj
 * @date 2022-03-19
 */
@Controller
@RequestMapping("/system/projectApply")
public class ProjectApplyController extends BaseController {
    private String prefix = "system/project";

    @Autowired
    private IProjectService projectService;

    @RequiresPermissions("system:project:applyview")
    @GetMapping()
    public String project() {
        return prefix + "/projectApply";
    }

    /**
     * 查询扶贫项目列表
     */
    @RequiresPermissions("system:project:applylist")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Project project) {
        startPage();
        project.setAuditStatus(1);
        List<Project> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }



    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:project:auditpass")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Project project) {
        project.setUpdateBy(ShiroUtils.getLoginName());
        project.setAuditId(ShiroUtils.getUserId().intValue());
        return toAjax(projectService.updateProject(project));
    }


    // 项目详情
    @RequestMapping("/detail/{applyId}")
    public String volunteerDetail(Model model, @PathVariable("applyId") Integer applyId) {

        model.addAttribute("applyId", applyId);
        return prefix + "/applysq";
    }
}
