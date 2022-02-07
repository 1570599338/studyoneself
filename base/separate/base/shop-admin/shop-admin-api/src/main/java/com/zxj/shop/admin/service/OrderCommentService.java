package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.OrderComment;

public interface OrderCommentService {

    IPage<OrderComment> page(Page<OrderComment> objectPage);

}
