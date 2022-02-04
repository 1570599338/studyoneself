package com.zxj.shop.admin.service;


import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.entity.vo.PermissionRespNode;
import com.zxj.shop.admin.entity.vo.RolePermissionParam;

import java.util.List;

public interface PermissionService {

	List<Permission> getUserPermission(String roleId);

	List<Permission> list();

	List<PermissionRespNode> selectAllMenuByTree(String permissionId);

	boolean savePermission(Permission vo);

	boolean updatePermission(Permission vo);

	public List<RolePermissionParam> setPermission (List<Permission> resourceList, String superId, Boolean spread, List<Integer> menuIdList);
}
