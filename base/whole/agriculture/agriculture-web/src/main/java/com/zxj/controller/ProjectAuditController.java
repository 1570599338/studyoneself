package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import com.zxj.common.shiro.ShiroUtils;
import com.zxj.domain.Project;
import com.zxj.service.IProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/system/projectaduit")
public class ProjectAuditController extends BaseController {
    private String prefix = "system/project";

    @Autowired
    private IProjectService projectService;

    @RequiresPermissions("system:project:auditview")
    @GetMapping()
    public String project() {
        return prefix + "/projectAudit";
    }

    /**
     * 查询扶贫项目列表
     */
    @RequiresPermissions("system:project:auditlist")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Project project) {
        startPage();
        project.setAuditStatus(0);
        List<Project> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }

    /**
     * 导出扶贫项目列表
     */
    @RequiresPermissions("system:project:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Project project) {
        List<Project> list = projectService.selectProjectList(project);
        ExcelUtil<Project> util = new ExcelUtil<Project>(Project.class);
        return util.exportExcel(list, "project");
    }

    /**
     * 新增扶贫项目
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存扶贫项目
     */
    @RequiresPermissions("system:project:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Project project) {
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改扶贫项目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Project project = projectService.selectProjectById(id);
        mmap.put("project", project);
        return prefix + "/edit";
    }

    /**
     * 修改保存扶贫项目
     */
    @RequiresPermissions("system:project:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Project project) {
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除扶贫项目
     */
    @RequiresPermissions("system:project:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(projectService.deleteProjectByIds(ids));
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
}
