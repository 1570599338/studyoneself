package com.hong.domain;

import lombok.ToString;

import java.io.Serializable;

/**
 * 角色和部门关联表(RoleDept)实体类
 *
 * @author hong
 * @since 2022-02-09 00:01:36
 */
@ToString
public class RoleDept implements Serializable {
    private static final long serialVersionUID = -56893650755182322L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}

