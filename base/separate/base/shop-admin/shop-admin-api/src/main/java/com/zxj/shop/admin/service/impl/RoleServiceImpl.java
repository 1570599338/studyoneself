package com.zxj.shop.admin.service.impl;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.entity.RolePermission;
import com.zxj.shop.admin.entity.UserRole;
import com.zxj.shop.admin.exception.BusinessException;
import com.zxj.shop.admin.mapper.RoleMapper;
import com.zxj.shop.admin.mapper.UserMapper;
import com.zxj.shop.admin.service.RolePermissionService;
import com.zxj.shop.admin.service.RoleService;
import com.zxj.shop.admin.entity.vo.RolePermissionParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionService rolePermissionService;


	@Override
	public List<Role> getRoles() {
		return roleMapper.selectList(new QueryWrapper<>());
	}

	@Override
	public List<Role> getUserRoles(String userId) {
		return roleMapper.getUserRoles(userId);
	}

	@Override
	public IPage<Role> page(Page<Role> rolePage, Role role) {
		return roleMapper.selectPage(rolePage, new QueryWrapper<>());
	}

	@Override
	public void addRolePermission(Role sysRole, List<RolePermissionParam> rolePermissionParamList) {
		RolePermission sysPermission = new RolePermission();
		sysPermission.setRoleId(sysRole.getId());
		for (RolePermissionParam permissionParam : rolePermissionParamList) {
			sysPermission.setPermissionId(permissionParam.getId());
			rolePermissionService.save(sysPermission);
			if (CollUtil.isNotEmpty(permissionParam.getChildren())) {
				addRolePermission(sysRole, permissionParam.getChildren());
			}
		}
	}

	@Override
	public Boolean confirmAdd(Role sysRole,String rolePermissionStr) {
		JSONArray array = JSONUtil.parseArray(rolePermissionStr);
		List<RolePermissionParam> rolePermissionParamList = new ArrayList<>();
		for (Object object : array) {
			rolePermissionParamList.add(JSONUtil.toBean(object.toString(), RolePermissionParam.class));
		}
		if(getRoles().stream().anyMatch(e -> e.getName().equals(sysRole.getName()))) {
			throw new BusinessException("?????????????????????");
		}
		sysRole.setRoleCode(sysRole.getName());
		save(sysRole);
		addRolePermission(sysRole, rolePermissionParamList);
		return true;
	}

	@Override
	public Boolean confirmEdit(Role sysRole, String rolePermission) {
		// ??????????????????
		val rst = updateById(sysRole);
		// ????????????????????????
		val sysPermissionWrapper = new QueryWrapper<RolePermission>();
		LambdaQueryWrapper<RolePermission> sysPermissionQueryWrapper = sysPermissionWrapper.lambda();
		sysPermissionQueryWrapper.eq(RolePermission::getRoleId, sysRole.getId());
		rolePermissionService.remove(sysPermissionQueryWrapper);
		// ??????????????????
		JSONArray array = JSONUtil.parseArray(rolePermission);
		List<RolePermissionParam> rolePermissionParamList = new ArrayList<>();
		for (Object object : array) {
			rolePermissionParamList.add(JSONUtil.toBean(object.toString(), RolePermissionParam.class));
		}
		if (rst) {
			addRolePermission(sysRole, rolePermissionParamList);
		}
		return true;
	}

	/**
	 *  ????????????
	 * @param roleId
	 * @return
	 */
	@Override
	public Boolean confirmDetel(Integer roleId) {
		// 1????????????????????????????????????
		roleMapper.deleteUserRole(roleId);
		//2????????????????????????
		roleMapper.deleteRolePermission(roleId);
		//3???????????????id
		roleMapper.deleteById(roleId);
		return true;
	}


}
