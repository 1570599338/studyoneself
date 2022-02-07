package com.zxj.shop.admin.controller;


import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.service.PermissionService;
import com.zxj.shop.admin.entity.vo.PageVO;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/api/admin/setting/menu")
public class MenuApiController {

    @Autowired
    PermissionService permissionService;

    @ApiOperation(value = "权限列表")
    @GetMapping("/list")
    public PageVO<Permission> list() {
        List<Permission> list = permissionService.list();
        return PageVO.pageVO(list, (long) list.size());
    }

    @GetMapping("/tree")
    @ApiOperation(value = "获取所有目录菜单树接口")
    public ResultVO getAllMenusPermissionTree(@RequestParam(required = false) String permissionId) {
        return ResultVO.success(permissionService.selectAllMenuByTree(permissionId));
    }

    @PostMapping("/savePermission")
    @ApiOperation(value = "新增菜单权限接口")
    public ResultVO savePermission(@RequestBody @Valid Permission vo) {
        return ResultVO.success(permissionService.savePermission(vo));
    }

    @PostMapping("/updatePermission")
    @ApiOperation(value = "更新菜单权限接口")
    public ResultVO updatePermission(@RequestBody @Valid Permission vo) {
        return ResultVO.success(permissionService.updatePermission(vo));
    }


    /**
     * 获取上一菜单名称
     *
     * @param id
     * @return
     */
    @RequestMapping("/menuById/{id}")
    @ApiOperation(value = "获取所有目录菜单树接口")
    public ResultVO getMenusPermissionById(@PathVariable("id")  Integer id) {
        Permission bean = permissionService.getPermissionById(id);
        return ResultVO.success(bean);
    }


}
