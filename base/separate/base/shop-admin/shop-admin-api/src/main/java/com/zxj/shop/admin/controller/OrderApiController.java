package com.zxj.shop.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.OrderComment;
import com.zxj.shop.admin.entity.Orders;
import com.zxj.shop.admin.entity.OrdersProduct;
import com.zxj.shop.admin.service.OrderCommentService;
import com.zxj.shop.admin.service.OrdersService;
import com.zxj.shop.admin.entity.vo.PageBean;
import com.zxj.shop.admin.entity.vo.PageVO;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "订单管理")
@RestController
@RequestMapping("/api/admin/order")
public class OrderApiController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderCommentService orderCommentService;

    @ApiOperation(value = "订单列表")
    @GetMapping("/list")
    public PageVO<Orders> list(PageBean pageBean) {
        IPage<Orders> logLoginPage = ordersService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }


    @ApiOperation(value = "订单列表")
    @GetMapping("/orderList")
    public ResultVO<List<OrdersProduct>> orderList(Orders orders) {
        return ResultVO.successTree(ordersService.orderList(orders));
    }


    @ApiOperation(value = "订单评价")
    @GetMapping("/commets")
    public PageVO<OrderComment> commets(PageBean pageBean) {
        IPage<OrderComment> logLoginPage = orderCommentService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }

}
