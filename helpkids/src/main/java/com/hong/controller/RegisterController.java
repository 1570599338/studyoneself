package com.hong.controller;


import com.hong.bean.Resp.AjaxResult;
import com.hong.common.UserConstants;
import com.hong.domain.User;
import com.hong.service.RoleService;
import com.hong.service.UserService;
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

    private String prefix = "admin/user";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String register(ModelMap mmap) {
        mmap.put("roles", roleService.selectRoleAll().stream().filter(s -> "need_helpKid".equals(s.getRoleKey()) ||
                "love_volunteer".equals(s.getRoleKey())).collect(Collectors.toList()));
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
            Long[] roleids={3l};
            user.setRoleIds(roleids);
        }
        if("02".equals(user.getUserType())){// 求助者need_helpKid
            Long[] roleids={4l};
            user.setRoleIds(roleids);
        }
        return toAjax(userService.insertUser(user));
    }
}
