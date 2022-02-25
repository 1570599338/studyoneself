package com.hong.controller;

import com.hong.common.shiro.ShiroUtils;
import com.hong.domain.Menu;
import com.hong.domain.User;
import com.hong.mapper.RoleMapper;
import com.hong.service.MenuService;
import com.hong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页 业务处理
 *
 * @author hong
 */
@Controller
public class IndexController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Resource
    private RoleMapper roleMapper;



    // 系统首页
    @GetMapping("/index")
    public String index(String tourist, ModelMap mmap) {

        // 取身份信息
       User user = ShiroUtils.getSysUser();
        if(user==null || user.getLoginName()==null){
            ShiroUtils.logout();
            ShiroUtils.clearCachedAuthorizationInfo();
            return "login";
        }



        ShiroUtils.setSysUser(user);
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("tourist", tourist);
        List<String> roleKeyList = roleMapper.selectRoleKey(ShiroUtils.getUserId());
        if (roleKeyList.contains("love_volunteer")) {
            if ("0".equals(user.getVip())) {
                mmap.put("love_volunteer", "love_volunteer");
            }
        }


        return "index";
    }

    // 切换主题
    @GetMapping("/admin/switchSkin")
    public String switchSkin(ModelMap mmap) {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/admin/main")
    public String main(ModelMap mmap) {
        mmap.put("version", "V1.0");
        return "main";
    }
}
