package com.zxj.shop.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.Product;
import com.zxj.shop.admin.mapper.ProductMapper;
import com.zxj.shop.admin.service.ProductService;
import com.zxj.shop.admin.entity.vo.ProductRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("master_4")
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public IPage<Product> page(Page<Product> objectPage) {
        return productMapper.selectPage(objectPage,new QueryWrapper<>());
    }

    @Override
    public Boolean createProduct(ProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        return this.save(product);
    }

    @Override
    public Product getProduct(ProductRequest request) {
        return productMapper.selectById(request.getId());
    }
}
