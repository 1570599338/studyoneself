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
import com.zxj.domain.Activity;
import com.zxj.service.IActivityService;

/**
 * 惠农之路Controller
 *
 * @author zxj
 * @date 2022-03-21
 */
@Controller
@RequestMapping("/system/activity")
public class ActivityController extends BaseController {
    private String prefix = "system/activity";

    @Autowired
    private IActivityService activityService;

    @RequiresPermissions("system:activity:view")
    @GetMapping()
    public String activity() {
        return prefix + "/activity";
    }

    /**
     * 查询惠农之路列表
     */
    @RequiresPermissions("system:activity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Activity activity) {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        return getDataTable(list);
    }

    /**
     * 导出惠农之路列表
     */
    @RequiresPermissions("system:activity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Activity activity) {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        return util.exportExcel(list, "activity");
    }

    /**
     * 新增惠农之路
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存惠农之路
     */
    @RequiresPermissions("system:activity:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Activity activity) {
        return toAjax(activityService.insertActivity(activity));
    }

    /**
     * 修改惠农之路
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Activity activity = activityService.selectActivityById(id);
        mmap.put("activity", activity);
        return prefix + "/edit";
    }

    /**
     * 修改保存惠农之路
     */
    @RequiresPermissions("system:activity:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Activity activity) {
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除惠农之路
     */
    @RequiresPermissions("system:activity:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(activityService.deleteActivityByIds(ids));
    }



    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:activity:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Activity activity) {

        return toAjax(activityService.updateActivity(activity));
    }
}
