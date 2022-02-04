package com.zxj.shop.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.service.PermissionService;
import com.zxj.shop.admin.service.RoleService;
import com.zxj.shop.admin.entity.vo.PageBean;
import com.zxj.shop.admin.entity.vo.PageVO;
import com.zxj.shop.admin.entity.vo.ResultVO;
import com.zxj.shop.admin.entity.vo.RolePermissionParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "角色权限管理")
@RestController
@RequestMapping("/api/admin/setting/rolePermission")
public class RolePermissionApiController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/roles")
    public ResultVO<List<Role>> roles() {
        return ResultVO.success(roleService.getRoles());
    }

    @GetMapping("/list")
    public PageVO<Role> list(Role role, PageBean pageBean) {
        IPage<Role> rolePage = roleService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()), role);
        return PageVO.pageVO(rolePage.getRecords(), rolePage.getTotal());
    }

    @PostMapping("/edit")
    public ResultVO<Role> edit(Integer id) {
        return ResultVO.success(roleService.getById(id));
    }

    @GetMapping("/addPermission")
    public List<RolePermissionParam> addPermission() {
        return permissionService.setPermission(permissionService.list(), "0", true, null);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("/confirm/add")
    public ResultVO<?> confirmAdd(Role sysRole,String rolePermission) {
        return ResultVO.success(roleService.confirmAdd(sysRole,rolePermission));
    }

    @RequiresRoles(value = {"superadmin"},logical = Logical.OR)
    @ApiOperation(value = "编辑角色")
    @PostMapping("/confirm/edit")
    public ResultVO<?> confirmEdit(Role sysRole,String rolePermission) {
        return ResultVO.success(roleService.confirmEdit(sysRole,rolePermission));
    }


    @PostMapping("/editPermission")
    public List<RolePermissionParam> editPermission(Integer roleId) {
        List<Permission> sysPermissionList = permissionService.getUserPermission(roleId.toString());
        return permissionService.setPermission(permissionService.list(), "0", true,  sysPermissionList.stream().map(e -> e.getId()).collect(Collectors.toList()));
    }

    @RequestMapping("/confirm/delete/{id}")
    public ResultVO<Role> delete(@PathVariable("id")  Integer id) {
        System.out.println("###############id = " + id);
        roleService.confirmDetel(id);
        return ResultVO.success();
    }

}
