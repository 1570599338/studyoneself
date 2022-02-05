package com.zxj.shop.admin.entity.dto;

import lombok.Data;

@Data
public class Passwd {

    private String token;
    private String id;
    private String oldPassword;
    private String password;
}
