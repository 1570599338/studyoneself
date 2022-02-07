package com.zxj.shop.admin.service;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.entity.vo.RolePermissionParam;

import java.util.List;


public interface RoleService extends IService<Role> {

	List<Role> getRoles();

	List<Role> getUserRoles(String userid);

	IPage<Role> page(Page<Role> rolePage, Role role);

	void addRolePermission(Role sysRole, List<RolePermissionParam> rolePermissionParamList);

	Boolean confirmAdd(Role sysRole, String rolePermissionStr);

	Boolean confirmEdit(Role sysRole, String rolePermission);

	Boolean confirmDetel(Integer roleId);
}
