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


	/**
	 * 根据id进行数据查询
	 * @param id
	 * @return
	 */
	Permission getPermissionById(Integer id);

	/**
	 * 根据父节点进行数据查询
	 * @param pid
	 * @return
	 */
	List<Permission>  getPermissionByPid(Integer pid);

	/**
	 * 对接点进行删除
	 * @param id
	 */
	void delPermission(Integer id);
}
