package com.hong.controller;

import com.hong.bean.Resp.AjaxResult;
import com.hong.common.page.TableDataInfo;
import com.hong.common.poi.ExcelUtil;
import com.hong.common.shiro.ShiroUtils;
import com.hong.common.utils.Constants;
import com.hong.domain.User;
import com.hong.domain.Wish;
import com.hong.service.IWishService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 关于我们Controller
 *
 * @author
 * @date 2022-02-21
 */
@Controller
@RequestMapping("/admin/wish")
public class WishController extends BaseController {
    private String prefix = "admin/wish";

    @Autowired
    private IWishService wishService;

    @RequiresPermissions("system:wish:view")
    @GetMapping()
    public String wish() {
        return prefix + "/wish";
    }

    /**
     * 查询关于我们列表
     */
    @RequiresPermissions("system:wish:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Wish wish) {
        User user = ShiroUtils.getSysUser();
        if(!user.isAdmin()){
            wish.setUserId(user.getId().intValue());
        }
        startPage();
        List<Wish> list = wishService.selectWishList(wish);
        return getDataTable(list);
    }

    /**
     * 导出关于我们列表
     */
    @RequiresPermissions("system:wish:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Wish wish) {
        List<Wish> list = wishService.selectWishList(wish);
        ExcelUtil<Wish> util = new ExcelUtil<Wish>(Wish.class);
        return util.exportExcel(list, "wish");
    }

    /**
     * 新增关于我们
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存关于我们
     */
    @RequiresPermissions("system:wish:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Wish wish) {
        return toAjax(wishService.insertWish(wish));
    }

    /**
     * 修改关于我们
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Wish wish = wishService.selectWishById(id);
        mmap.put("wish", wish);
        return prefix + "/edit";
    }

    /**
     * 修改保存关于我们
     */
    @RequiresPermissions("system:wish:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Wish wish) {
        return toAjax(wishService.updateWish(wish));
    }

    /**
     * 删除关于我们
     */
    @RequiresPermissions("system:wish:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wishService.deleteWishByIds(ids));
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<待审核数据>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    @RequiresPermissions("system:wishA:view")
    @GetMapping("/auditView")
    public String wishA() {
        return prefix + "/wishAudit";
    }

    /**
     * 查询关于我们列表
     */
    @RequiresPermissions("system:wishA:list")
    @PostMapping("/auditlist")
    @ResponseBody
    public TableDataInfo listA(Wish wish) {
        User user = ShiroUtils.getSysUser();
        if(!user.isAdmin()){
            wish.setUserId(user.getId().intValue());
        }
        wish.setAuditStatus(Constants.audit_init);
        startPage();
        List<Wish> list = wishService.selectWishList(wish);
        return getDataTable(list);
    }

    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:auditF:edit")
    @PostMapping("/changeAudt")
    @ResponseBody
    public AjaxResult changeAudtF(Wish wish) {
        wish.setAuditId(ShiroUtils.getUserId().intValue());
        return toAjax(wishService.updateWish(wish));
    }



    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<守护心愿>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /**
     * 跳转到守护心愿界面
     * @return
     */
    @RequiresPermissions("system:wishA:view")
    @GetMapping("/VolunteerView")
    public String wishV() {
        return prefix + "/wishVolunteer";
    }

    /**
     * 查询守护心愿的数据
     */
    @RequiresPermissions("system:wishV:list")
    @PostMapping("/volunteerList")
    @ResponseBody
    public TableDataInfo volunteerList(Wish wish) {
        User user = ShiroUtils.getSysUser();
        if(!user.isAdmin()){
            wish.setAuditId(user.getId().intValue());//负责或者跟踪的帮扶对象的心愿
        }
        wish.setAuditStatus(Constants.audit_pass);
        startPage();
        List<Wish> list = wishService.selectWishList(wish);
        return getDataTable(list);
    }


}
