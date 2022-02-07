package com.zxj.shop.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@TableName("orders")
@Data
public class Orders {

    private Integer id;

    private String orderSn;

    private String paySn;

    private String realName;

    private String orderStatus;

    private String source;

    private Date createTime;

    private BigDecimal orderMoney;

    private BigDecimal distinctMoney;

    private String mobile;

    private String address;
}
