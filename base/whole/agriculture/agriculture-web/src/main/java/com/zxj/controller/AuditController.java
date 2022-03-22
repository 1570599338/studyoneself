package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.UserConstants;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.utils.Constants;
import com.zxj.domain.User;
import com.zxj.service.IRoleService;
import com.zxj.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springs
 * @description: 主要对人员进行审核
 * @author: zxj
 * @create: 2022-02-21 19:21
 **/
@Controller
@RequestMapping("/system")
public class AuditController extends BaseController{
    private String prefix = "system/audit";
    /**
     * 服务对象
     */
    @Resource
    private IUserService userService;

    @Autowired
    private IRoleService roleService;


    /**
     * 审核志愿者
     * @return
     */
    @RequiresPermissions("system:audit:view")
    @GetMapping("/audit")
    public String user() {
        return prefix + "/audit";
    }

    @RequiresPermissions("system:audit:list")
    @PostMapping("/audit/list")
    @ResponseBody
    public TableDataInfo list(User user) {
        user.setAudit(Constants.audit_init);
        user.setUserType(Constants.USER_ZY);
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:audit:edit")
    @PostMapping("/audit/changeAudt")
    @ResponseBody
    public AjaxResult changeStatus(User user) {
        userService.checkUserAllowed(user);
        return toAjax(userService.changeStatus(user));
    }

    /**
     * 修改用户
     */
    @GetMapping("/audit/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));

        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:audit:edit")
    @PostMapping("/audit/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated User user) {
        userService.checkUserAllowed(user);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        return toAjax(userService.updateUser(user));
    }





    /**
     * 审核求助者
     * @return
     */

    @RequiresPermissions("system:auditQ:view")
    @GetMapping("/auditQ")
    public String auditQ() {
        return prefix + "/auditQ";
    }


    @RequiresPermissions("system:auditQ:list")
    @PostMapping("/auditQ/list")
    @ResponseBody
    public TableDataInfo listQ(User user) {
        user.setAudit(Constants.audit_init);
        user.setUserType(Constants.USER_QZ);
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:auditQ:edit")
    @PostMapping("/auditQ/changeAudt")
    @ResponseBody
    public AjaxResult changeAudtQ(User user) {
        userService.checkUserAllowed(user);
        return toAjax(userService.changeStatus(user));
    }


    @GetMapping("/auditQ/editQ/{userId}")
    public String editQ(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));

        return prefix + "/editQ";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:auditQ:edit")
    @PostMapping("/auditQ/editQ")
    @ResponseBody
    public AjaxResult editSaveQ(@Validated User user) {
        userService.checkUserAllowed(user);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        return toAjax(userService.updateUser(user));
    }


    /**
     * 审核失败
     * @return
     */

    @RequiresPermissions("system:auditF:view")
    @GetMapping("/auditF")
    public String auditF() {
        return prefix + "/auditF";
    }


    @RequiresPermissions("system:auditF:list")
    @PostMapping("/auditF/list")
    @ResponseBody
    public TableDataInfo listF(User user) {
        user.setAudit(Constants.audit_fail);
       // user.setUserType(Constants.USER);
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    /**
     * 用户状态修改
     */
    @RequiresPermissions("system:auditF:edit")
    @PostMapping("/auditF/changeAudt")
    @ResponseBody
    public AjaxResult changeAudtF(User user) {
        userService.checkUserAllowed(user);
        return toAjax(userService.changeStatus(user));
    }

    @GetMapping("/auditF/editF/{userId}")
    public String editF(@PathVariable("userId") Long userId, ModelMap mmap) {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));

        return prefix + "/editF";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:auditF:edit")
    @PostMapping("/auditF/editF")
    @ResponseBody
    public AjaxResult editSaveF(@Validated User user) {
        userService.checkUserAllowed(user);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        return toAjax(userService.updateUser(user));
    }

}
