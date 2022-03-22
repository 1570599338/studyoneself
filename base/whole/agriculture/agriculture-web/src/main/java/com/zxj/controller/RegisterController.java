package com.zxj.controller;


import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.UserConstants;
import com.zxj.domain.User;
import com.zxj.service.IRoleService;
import com.zxj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class RegisterController extends BaseController {

    private String prefix = "system/user";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping()
    public String register(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(s -> "enterprise".equals(s.getRoleKey()) ||
                "job_wanted".equals(s.getRoleKey())).collect(Collectors.toList()));
        return prefix + "/register";
    }

    /**
     * 新增保存用户
     */
    @PostMapping("/register")
    @ResponseBody
    public AjaxResult register(@Validated User user) {
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(user.getLoginName()))) {
            return error("新增用户'" + user.getLoginName() + "'失败，登录账号已存在");
        } else if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，手机号码已存在");
        } else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return error("新增用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        if("01".equals(user.getUserType())){// 志愿者love_volunteer
            Long[] roleids={8l};
            user.setRoleIds(roleids);
        }
        if("02".equals(user.getUserType())){// 求助者need_helpKid
            Long[] roleids={7l};
            user.setRoleIds(roleids);
        }
        user.setAudit(0);
        return toAjax(userService.insertUser(user));
    }
}
