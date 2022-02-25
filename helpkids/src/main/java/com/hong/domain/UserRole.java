package com.hong.domain;

import lombok.ToString;

import java.io.Serializable;

/**
 * 用户和角色关联表(UserRole)实体类
 *
 * @author hong
 * @since 2022-02-09 00:03:47
 */
@ToString
public class UserRole implements Serializable {
    private static final long serialVersionUID = 190580110578431486L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}

