package com.zxj.shop.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.OrderComment;
import com.zxj.shop.admin.mapper.OrderCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DS("master_3")
@Service
public class OrderCommentService implements com.zxj.shop.admin.service.OrderCommentService {

    @Autowired
    OrderCommentMapper orderCommentMapper;

    @Override
    public IPage<OrderComment> page(Page<OrderComment> objectPage) {
        return orderCommentMapper.selectPage(objectPage,new QueryWrapper<>());
    }
}
