package com.zxj.controller;

import java.util.List;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxj.domain.VolunteerStyle;
import com.zxj.service.IVolunteerStyleService;


/**
 * 志愿者风采Controller
 *
 * @author zxj
 * @date 2022-03-20
 */
@Controller
@RequestMapping("/system/style")
public class VolunteerStyleController extends BaseController {
    private String prefix = "system/style";

    @Autowired
    private IVolunteerStyleService volunteerStyleService;

    @RequiresPermissions("system:style:view")
    @GetMapping()
    public String style() {
        return prefix + "/style";
    }

    /**
     * 查询志愿者风采列表
     */
    @RequiresPermissions("system:style:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VolunteerStyle volunteerStyle) {
        startPage();
        List<VolunteerStyle> list = volunteerStyleService.selectVolunteerStyleList(volunteerStyle);
        return getDataTable(list);
    }

    /**
     * 导出志愿者风采列表
     */
    @RequiresPermissions("system:style:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VolunteerStyle volunteerStyle) {
        List<VolunteerStyle> list = volunteerStyleService.selectVolunteerStyleList(volunteerStyle);
        ExcelUtil<VolunteerStyle> util = new ExcelUtil<VolunteerStyle>(VolunteerStyle.class);
        return util.exportExcel(list, "style");
    }

    /**
     * 新增志愿者风采
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存志愿者风采
     */
    @RequiresPermissions("system:style:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VolunteerStyle volunteerStyle) {
        return toAjax(volunteerStyleService.insertVolunteerStyle(volunteerStyle));
    }

    /**
     * 修改志愿者风采
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        VolunteerStyle volunteerStyle = volunteerStyleService.selectVolunteerStyleById(id);
        mmap.put("volunteerStyle", volunteerStyle);
        return prefix + "/edit";
    }

    /**
     * 修改保存志愿者风采
     */
    @RequiresPermissions("system:style:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VolunteerStyle volunteerStyle) {
        return toAjax(volunteerStyleService.updateVolunteerStyle(volunteerStyle));
    }

    /**
     * 删除志愿者风采
     */
    @RequiresPermissions("system:style:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(volunteerStyleService.deleteVolunteerStyleByIds(ids));
    }



    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:style:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(VolunteerStyle volunteerStyle) {

        return toAjax(volunteerStyleService.updateVolunteerStyle(volunteerStyle));
    }
}
