package com.zxj.shop.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("product")
@Data
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer productCateId;

    private String productName;

    private String sku;

    private String imgUrl;

    private Integer stock;

    private Integer sales;

    private Double mallMobilePrice;

    private Double originalPrice;

    private String title;

    private String description;

    private Date createTime;

}
