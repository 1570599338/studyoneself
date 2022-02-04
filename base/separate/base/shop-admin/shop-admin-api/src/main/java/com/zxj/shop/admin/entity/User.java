package com.zxj.shop.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@TableName("sys_user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
	private Integer id;

    private String name;

    private String password;

    private String salt;

    private String email;

    private String icon;

    private Date createDate;

    private String state;

    private Integer loginCount;

    private Date lastVisit;

    private Date birthday;

    private String gender;

    private String mobile;

    private String note;

    @TableField(exist=false)
    private List<String> roleIds;
    @TableField(exist = false)
    private String search;

    private Integer isLock;

    @Version
    private Integer version;
}