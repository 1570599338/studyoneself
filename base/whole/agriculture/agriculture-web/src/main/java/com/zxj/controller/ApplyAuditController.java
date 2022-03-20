package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.poi.ExcelUtil;
import com.zxj.domain.Apply;
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
@RequestMapping("/system/applyaudit")
public class ApplyAuditController extends BaseController {
    private String prefix = "system/apply";

    @Autowired
    private IApplyService applyService;

    @RequiresPermissions("system:apply:auditview")
    @GetMapping()
    public String apply() {
        return prefix + "/applyAudit";
    }

    /**
     * 查询申请列表
     */
    @RequiresPermissions("system:apply:auditlist")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Apply apply) {
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出申请列表
     */
    @RequiresPermissions("system:apply:auditexport")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Apply apply) {
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        return util.exportExcel(list, "apply");
    }



    /**
     * 修改申请
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Apply apply = applyService.selectApplyById(id);
        mmap.put("apply", apply);
        return prefix + "/editAudit";
    }

    /**
     * 修改保存申请
     */
    @RequiresPermissions("system:apply:auditedit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Apply apply) {
        return toAjax(applyService.updateApply(apply));
    }


}
