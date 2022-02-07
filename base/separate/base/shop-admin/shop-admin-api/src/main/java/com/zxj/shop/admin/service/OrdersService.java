package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.Orders;
import com.zxj.shop.admin.entity.OrdersProduct;

import java.util.List;

public interface OrdersService extends IService<Orders> {


    IPage<Orders> page(Page<Orders> objectPage);

    List<OrdersProduct> orderList(Orders orders);
}
