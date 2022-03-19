package com.zxj.controller;

import java.util.List;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import com.zxj.domain.Project;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zxj.service.IProjectService;

/**
 * 扶贫项目Controller
 *
 * @author zxj
 * @date 2022-03-19
 */
@Controller
@RequestMapping("/system/project")
public class ProjectController extends BaseController {
    private String prefix = "system/project";

    @Autowired
    private IProjectService projectService;

    @RequiresPermissions("system:project:view")
    @GetMapping()
    public String project() {
        return prefix + "/project";
    }

    /**
     * 查询扶贫项目列表
     */
    @RequiresPermissions("system:project:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Project project) {
        startPage();
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
}
