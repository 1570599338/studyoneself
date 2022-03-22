package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import com.zxj.common.shiro.ShiroUtils;
import com.zxj.domain.Apply;
import com.zxj.domain.User;
import com.zxj.service.IApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 申请Controller
 *
 * @author zxj
 * @date 2022-03-20
 */
@Controller
@RequestMapping("/system/apply")
public class ApplyController extends BaseController {
    private String prefix = "system/apply";

    @Autowired
    private IApplyService applyService;

    @RequiresPermissions("system:apply:view")
    @GetMapping()
    public String apply() {
        return prefix + "/apply";
    }

    /**
     * 查询申请列表
     */
    @RequiresPermissions("system:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Apply apply) {
        User user = ShiroUtils.getSysUser();
        if(!user.isAdmin()){
            apply.setUserId(user.getUserId().intValue());
        }
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出申请列表
     */
    @RequiresPermissions("system:apply:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Apply apply) {
        User user = ShiroUtils.getSysUser();
        if(!user.isAdmin()){
            apply.setUserId(user.getUserId().intValue());
        }
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增申请
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存申请
     */
    @RequiresPermissions("system:apply:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Apply apply) {
        apply.setUserId(ShiroUtils.getUserId().intValue());
        apply.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(applyService.insertApply(apply));
    }

    /**
     * 修改申请
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Apply apply = applyService.selectApplyById(id);
        mmap.put("apply", apply);
        return prefix + "/edit";
    }

    /**
     * 修改保存申请
     */
    @RequiresPermissions("system:apply:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Apply apply) {
        return toAjax(applyService.updateApply(apply));
    }

    /**
     * 删除申请
     */
    @RequiresPermissions("system:apply:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(applyService.deleteApplyByIds(ids));
    }
}
