package com.zxj.shop.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.ProductCate;
import com.zxj.shop.admin.mapper.ProductCateMapper;
import com.zxj.shop.admin.service.ProductCateService;
import org.springframework.stereotype.Service;

@Service
@DS("master_4")
public class ProductCateServiceImpl extends ServiceImpl<ProductCateMapper, ProductCate> implements ProductCateService {
}
