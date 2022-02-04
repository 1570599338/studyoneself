package com.zxj.shop.admin.controller;

import cn.hutool.json.JSONUtil;
import com.zxj.shop.admin.entity.dto.HomeIndex;
import com.zxj.shop.admin.service.*;
import com.zxj.shop.admin.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "初始化接口")
@RestController
@RequestMapping("/api")
public class InitApiController {

    @Autowired
    private ShiroService shiroService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SystemService systemService;


    @ApiOperation(value = "执行初始化功能")
    @GetMapping("/init")
    public String init(HttpServletRequest request) {
        String token = TokenUtil.getRequestToken(request);
        return JSONUtil.toJsonStr(systemService.init(token));
    }

    @ApiOperation(value = "初始化首页数据")
    @GetMapping("/home")
    public String home() {
        return JSONUtil.toJsonStr(new HomeIndex(shiroService.count(),productService.count(),ordersService.count(),systemService.count()));
    }
}
