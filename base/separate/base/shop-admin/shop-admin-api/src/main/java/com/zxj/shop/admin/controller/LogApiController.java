package com.zxj.shop.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.SysLog;
import com.zxj.shop.admin.service.SystemService;
import com.zxj.shop.admin.entity.vo.PageBean;
import com.zxj.shop.admin.entity.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "日志管理")
@RestController
@RequestMapping("/api/admin/setting/logLogin")
public class LogApiController {

    @Autowired
    SystemService systemService;

    @RequiresRoles(value = {"admin","guest","superadmin"},logical = Logical.OR)
    @ApiOperation(value = "日志列表")
    @GetMapping("/list")
    public PageVO<SysLog> list(PageBean pageBean) {
        IPage<SysLog> logLoginPage = systemService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }

}
