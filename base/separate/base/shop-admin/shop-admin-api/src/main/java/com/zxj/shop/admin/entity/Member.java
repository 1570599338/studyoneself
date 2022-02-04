package com.zxj.shop.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("member")
@Data
public class Member {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String gender;

    private String mobile;

    private String source;

    private Date createDate;

    private Integer loginCount;

    private Date lastVisit;
}
