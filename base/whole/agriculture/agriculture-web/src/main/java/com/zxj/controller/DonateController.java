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
import com.zxj.domain.Donate;
import com.zxj.service.IDonateService;

/**
 * 捐款Controller
 *
 * @author zxj
 * @date 2022-03-20
 */
@Controller
@RequestMapping("/system/donate")
public class DonateController extends BaseController {
    private String prefix = "system/donate";

    @Autowired
    private IDonateService donateService;

    @RequiresPermissions("system:donate:view")
    @GetMapping()
    public String donate() {
        return prefix + "/donate";
    }

    /**
     * 查询捐款列表
     */
    @RequiresPermissions("system:donate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Donate donate) {
        startPage();
        List<Donate> list = donateService.selectDonateList(donate);
        return getDataTable(list);
    }

    /**
     * 导出捐款列表
     */
    @RequiresPermissions("system:donate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Donate donate) {
        List<Donate> list = donateService.selectDonateList(donate);
        ExcelUtil<Donate> util = new ExcelUtil<Donate>(Donate.class);
        return util.exportExcel(list, "donate");
    }

    /**
     * 新增捐款
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存捐款
     */
    @RequiresPermissions("system:donate:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Donate donate) {
        return toAjax(donateService.insertDonate(donate));
    }

    /**
     * 修改捐款
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Donate donate = donateService.selectDonateById(id);
        mmap.put("donate", donate);
        return prefix + "/edit";
    }

    /**
     * 修改保存捐款
     */
    @RequiresPermissions("system:donate:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Donate donate) {
        return toAjax(donateService.updateDonate(donate));
    }

    /**
     * 删除捐款
     */
    @RequiresPermissions("system:donate:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(donateService.deleteDonateByIds(ids));
    }
}
