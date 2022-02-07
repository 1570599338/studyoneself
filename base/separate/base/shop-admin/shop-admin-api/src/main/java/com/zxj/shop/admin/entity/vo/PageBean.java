package com.zxj.shop.admin.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
public class PageBean implements Serializable {
    @ApiModelProperty(value = "每页页数")
    private Long page = 1L;
    @ApiModelProperty(value = "每页条数")
    private Long limit = 10L;
}
