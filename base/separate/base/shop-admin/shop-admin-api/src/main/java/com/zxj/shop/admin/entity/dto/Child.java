package com.zxj.shop.admin.entity.dto;

import lombok.Data;

import java.util.List;


@Data
public class Child {
    private Integer id;
    private String title;
    private String href;
    private String icon;
    private String target;
    private Integer source;
    private List<Child> child;
}