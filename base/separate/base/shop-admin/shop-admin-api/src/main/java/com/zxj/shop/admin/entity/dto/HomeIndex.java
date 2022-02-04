package com.zxj.shop.admin.entity.dto;

import lombok.Data;

@Data
public class HomeIndex {

    private Integer user;

    private Integer product;

    private Integer order;

    private Integer syslog;


    public HomeIndex(Integer user, Integer product, Integer order, Integer syslog) {
        this.user = user;
        this.product = product;
        this.order = order;
        this.syslog = syslog;
    }
}
