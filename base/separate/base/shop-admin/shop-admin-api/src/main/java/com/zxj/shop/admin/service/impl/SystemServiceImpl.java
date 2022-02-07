package com.zxj.shop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.entity.SysLog;
import com.zxj.shop.admin.entity.SysToken;
import com.zxj.shop.admin.entity.dto.*;
import com.zxj.shop.admin.mapper.LogMapper;
import com.zxj.shop.admin.service.PermissionService;
import com.zxj.shop.admin.service.RoleService;
import com.zxj.shop.admin.service.ShiroService;
import com.zxj.shop.admin.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemServiceImpl extends ServiceImpl<LogMapper,SysLog> implements SystemService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;

    @Override
    public IPage<SysLog> page(Page<SysLog> objectPage) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("login_time");
        return logMapper.selectPage(objectPage, wrapper);
    }

    @Override
    public Init init(String token) {
        Init init = new Init();
        // 缓存清理加载
        getClearInfo(init);
        // 首页加载
        getHomeInfo(init);
        // logo加载
        getLogoInfo(init);
        // 菜单加载
        getMenuInfo(token, init);
        return init;
    }


    private void getClearInfo(Init init) {
        ClearInfo clearInfo = new ClearInfo();
        clearInfo.setClearUrl("");
        init.setClearInfo(clearInfo);
    }

    private void getHomeInfo(Init init) {
        HomeInfo homeInfo = new HomeInfo();
        homeInfo.setTitle("首页");
        homeInfo.setIcon("fa fa-home");
        homeInfo.setHref("entry/home.html");
        init.setHomeInfo(homeInfo);
    }

    private void getLogoInfo(Init init) {
        LogoInfo logoInfo = new LogoInfo();
        logoInfo.setTitle("shop-admin");
        logoInfo.setImage("static/images/logo.png");
        logoInfo.setHref("");
        init.setLogoInfo(logoInfo);
    }

    private void getMenuInfo(String token, Init init) {
        SysToken accessToken = shiroService.findByToken(token);
        List<Role> roles = roleService.getUserRoles(accessToken.getUserId().toString());

        List<Permission> userResource = new ArrayList<>();
        roles.forEach(r -> {
            List<Permission> resource = permissionService.getUserPermission(r.getId().toString())
                    .stream().filter(e -> e.getCategory() !=3).collect(Collectors.toList());
            userResource.addAll(resource);
        });

        MenuInfo menuInfo = new MenuInfo();
        List<Menu> list = set(userResource.stream().sorted(Comparator.comparing(Permission::getSort)).distinct().collect(Collectors.toList()), 0);

        if (list.size() > 0) {
            menuInfo.setMenu1(list.get(0));
        }
        if (list.size() > 1) {
            menuInfo.setMenu2(list.get(1));
        }
        if (list.size() > 2) {
            menuInfo.setMenu3(list.get(2));
        }
        if (list.size() > 3) {
            menuInfo.setMenu4(list.get(3));
        }
        if (list.size() > 4) {
            menuInfo.setMenu5(list.get(4));
        }
        init.setMenuInfo(menuInfo);
    }

    private List<Menu> set(List<Permission> userResource, Integer superId) {
        // 一级菜单
        List<Menu> list = new ArrayList<>();
        for (Permission sysResource : userResource) {
            if (sysResource.getPid() == superId) {
                // 权限菜单
                Menu menu = new Menu();
                menu.setId(Long.parseLong(sysResource.getId().toString()));
                menu.setTitle(sysResource.getName());
                menu.setIcon(sysResource.getIcon());

                List<Child> childList = setChild(userResource, sysResource.getId());
                if (childList.size() > 0) {
                    menu.setChild(childList);
                }
                list.add(menu);
            }
        }
        return list;
    }

    private List<Child> setChild(List<Permission> userResource, Integer superId) {
        // 2级菜单
        List<Child> list = new ArrayList<>();
        for (Permission sysResource : userResource) {
            if (superId == sysResource.getPid()) {
                Child child = new Child();
                child.setId(sysResource.getId());
                child.setTitle(sysResource.getName());
                child.setIcon(sysResource.getIcon());
                child.setHref(sysResource.getUrl());
                child.setTarget(sysResource.getTarget());
                child.setSource(sysResource.getSource());

                List<Child> childList = setChild(userResource, sysResource.getId());
                if (childList.size() > 0) {
                    child.setChild(childList);
                }
                list.add(child);
            }
        }
        return list;
    }
}
