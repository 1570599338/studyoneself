package com.zxj.shop.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.Product;
import com.zxj.shop.admin.entity.ProductCate;
import com.zxj.shop.admin.service.ProductCateService;
import com.zxj.shop.admin.service.ProductService;
import com.zxj.shop.admin.entity.vo.PageBean;
import com.zxj.shop.admin.entity.vo.PageVO;
import com.zxj.shop.admin.entity.vo.ProductRequest;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品管理")
@RestController
@RequestMapping("/api/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCateService productCateService;


    @ApiOperation(value = "商品列表")
    @GetMapping("/list")
    public PageVO<Product> list(PageBean pageBean) {
        IPage<Product> logLoginPage = productService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }

    @ApiOperation(value = "创建商品")
    @GetMapping("/create")
    public ResultVO<Boolean> create(ProductRequest request) {
        return ResultVO.success(productService.createProduct(request));
    }

    @ApiOperation(value = "查看商品")
    @GetMapping("/view")
    public ResultVO<Product> view(ProductRequest request) {
        return ResultVO.success(productService.getProduct(request));
    }

    @ApiOperation(value = "商品类别列表")
    @GetMapping("/cate/list")
    public PageVO<ProductCate> cateList(PageBean pageBean) {
        IPage<ProductCate> logLoginPage = productCateService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }
}
