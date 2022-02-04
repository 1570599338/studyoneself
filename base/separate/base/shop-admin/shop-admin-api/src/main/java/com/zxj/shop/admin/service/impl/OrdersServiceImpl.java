package com.zxj.shop.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.Orders;
import com.zxj.shop.admin.entity.OrdersProduct;
import com.zxj.shop.admin.mapper.OrderProductMapper;
import com.zxj.shop.admin.mapper.OrdersMapper;
import com.zxj.shop.admin.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("master_3")
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper,Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public IPage<Orders> page(Page<Orders> objectPage) {
        LambdaQueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>().lambda();

        queryWrapper.orderByDesc(Orders::getCreateTime);

        return ordersMapper.selectPage(objectPage, queryWrapper);
    }

    @Override
    public List<OrdersProduct> orderList(Orders orders) {
        return orderProductMapper.selectList(new QueryWrapper<OrdersProduct>().eq("order_sn",orders.getOrderSn()));
    }
}
