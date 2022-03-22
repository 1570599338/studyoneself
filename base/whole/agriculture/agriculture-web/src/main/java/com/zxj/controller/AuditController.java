package com.zxj.controller;

import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.page.TableDataInfo;
import com.zxj.common.utils.Constants;
import com.zxj.domain.User;
import com.zxj.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
