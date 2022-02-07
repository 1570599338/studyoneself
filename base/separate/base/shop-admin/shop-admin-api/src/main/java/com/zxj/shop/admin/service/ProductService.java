package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.Product;
import com.zxj.shop.admin.entity.vo.ProductRequest;

public interface ProductService extends IService<Product> {

    IPage<Product> page(Page<Product> objectPage);

    Boolean createProduct(ProductRequest request);

    Product getProduct(ProductRequest request);
}
