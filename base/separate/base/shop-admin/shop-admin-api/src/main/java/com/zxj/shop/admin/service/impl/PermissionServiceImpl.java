package com.zxj.shop.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.entity.vo.RolePermissionParam;
import com.zxj.shop.admin.exception.BaseResponseCode;
import com.zxj.shop.admin.exception.BusinessException;
import com.zxj.shop.admin.mapper.PermissionMapper;
import com.zxj.shop.admin.service.PermissionService;
import com.zxj.shop.admin.entity.vo.PermissionRespNode;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> getUserPermission(String roleId) {
		return permissionMapper.getUserPermission(roleId);
	}

	@Override
	public List<Permission> list() {
		LambdaQueryWrapper<Permission> queryWrapper = new QueryWrapper().lambda();
		queryWrapper.orderByDesc(Permission::getSort);
		return permissionMapper.selectList(queryWrapper);
	}

	@Override
	public List<PermissionRespNode> selectAllMenuByTree(String permissionId) {
		List<Permission> list = list();
		if (!CollectionUtils.isEmpty(list) && !StringUtils.isEmpty(permissionId)) {
			for (Permission sysPermission : list) {
				if (sysPermission.getId().equals(permissionId)) {
					list.remove(sysPermission);
					break;
				}
			}
		}
		List<PermissionRespNode> result = new ArrayList<>();
		//新增顶级目录是为了方便添加一级目录
		PermissionRespNode respNode = new PermissionRespNode();
		respNode.setId("1");
		respNode.setTitle("默认顶级菜单");
		respNode.setSpread(true);
		respNode.setChildren(getTree(list, true));
		result.add(respNode);
		return result;
	}

	@Override
	public boolean savePermission(Permission vo) {
		verifyFormPid(vo);
		permissionMapper.insert(vo);
		return true;
	}

	@Override
	public boolean updatePermission(Permission vo) {
		if (StringUtils.isEmpty(vo.getId())) {
			throw new BusinessException("id 不能为空");
		}
		Permission sysPermission = permissionMapper.selectById(vo.getId());
		if (null == sysPermission) {
			throw new BusinessException(BaseResponseCode.DATA_ERROR);
		}
		// 只有类型变更或者所属菜单变更
		if (sysPermission.getType().equals(vo.getType()) || !sysPermission.getPid().equals(vo.getPid())) {
			verifyFormPid(vo);
		}
		permissionMapper.updateById(vo);
		return true;
	}

	/**
	 * 递归获取菜单树
	 */
	private List<PermissionRespNode> getTree(List<Permission> all, boolean type) {
		List<PermissionRespNode> list = new ArrayList<>();

		for (Permission sysPermission : all) {
			if (1 == sysPermission.getPid()) {
				PermissionRespNode permissionRespNode = new PermissionRespNode();
				permissionRespNode.setId(sysPermission.getId().toString());
				permissionRespNode.setTitle(sysPermission.getName());
				permissionRespNode.setPid(sysPermission.getPid().toString());
				permissionRespNode.setOrderNum(sysPermission.getSort());

				if (type) {
					permissionRespNode.setChildren(getChildExcBtn(sysPermission.getId(), all));
				} else {
					permissionRespNode.setChildren(getChildAll(sysPermission.getId(), all));
				}
				list.add(permissionRespNode);
			}
		}
		return list;
	}

	/**
	 * 递归遍历所有
	 */
	private List<PermissionRespNode> getChildAll(Integer id, List<Permission> all) {

		List<PermissionRespNode> list = new ArrayList<>();
		for (Permission sysPermission : all) {
			if (sysPermission.getPid() == id) {
				PermissionRespNode permissionRespNode = new PermissionRespNode();
				permissionRespNode.setId(sysPermission.getId().toString());
				permissionRespNode.setTitle(sysPermission.getName());
				permissionRespNode.setPid(sysPermission.getPid().toString());
				permissionRespNode.setOrderNum(sysPermission.getSort());
				permissionRespNode.setChildren(getChildAll(sysPermission.getId(), all));
				list.add(permissionRespNode);
			}
		}
		return list;
	}

	/**
	 * 只递归获取目录和菜单
	 */
	private List<PermissionRespNode> getChildExcBtn(Integer id, List<Permission> all) {

		List<PermissionRespNode> list = new ArrayList<>();
		for (Permission sysPermission : all) {
			if (sysPermission.getPid().intValue() == id && sysPermission.getCategory() != 3) {
				PermissionRespNode permissionRespNode = new PermissionRespNode();
				permissionRespNode.setId(sysPermission.getId().toString());
				permissionRespNode.setTitle(sysPermission.getName());
				permissionRespNode.setPid(sysPermission.getPid().toString());
				permissionRespNode.setOrderNum(sysPermission.getSort());
				permissionRespNode.setChildren(getChildExcBtn(sysPermission.getId(), all));
				list.add(permissionRespNode);
			}
		}
		return list;
	}

	/**
	 * 操作后的菜单类型是目录的时候 父级必须为目录
	 * 操作后的菜单类型是菜单的时候，父类必须为目录类型
	 * 操作后的菜单类型是按钮的时候 父类必须为菜单类型
	 */
	private void verifyFormPid(Permission sysPermission) {
		Permission parent;
		parent = permissionMapper.selectById(sysPermission.getPid());
		switch (sysPermission.getCategory()) {
			case 1:
				if (parent != null) {
					if (parent.getCategory() != 1) {
						throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
					}
				} else if (!"0".equals(sysPermission.getPid())) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_CATALOG_ERROR);
				}
				break;
			case 2:
				if (parent == null || parent.getCategory() != 2) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_MENU_ERROR);
				}
				if (StringUtils.isEmpty(sysPermission.getUrl())) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
				}

				break;
			case 3:
				if (parent == null || parent.getCategory() != 2) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_BTN_ERROR);
				}
				if (StringUtils.isEmpty(sysPermission.getPermCode())) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_PERMS_NULL);
				}
				if (StringUtils.isEmpty(sysPermission.getUrl())) {
					throw new BusinessException(BaseResponseCode.OPERATION_MENU_PERMISSION_URL_NOT_NULL);
				}
				break;
			default:
		}
	}


	public List<RolePermissionParam> setPermission (List<Permission> resourceList, String superId, Boolean spread, List<Integer> menuIdList)  {
		List list = new ArrayList<RolePermissionParam>();
		for (Permission sysResource : resourceList) {
			if (superId.equals(sysResource.getPid().toString())) {
				val param = new RolePermissionParam();
				param.setTitle(sysResource.getName());
				param.setId(sysResource.getId());
				param.setSpread(spread);
				param.setDisabled(false);
				List rolePermissionParams = setPermission(resourceList, sysResource.getId().toString(), spread, menuIdList);
				if (CollUtil.isNotEmpty(rolePermissionParams)) {
					param.setChildren(rolePermissionParams);
				} else {
					param.setChildren(new ArrayList<>());
					// 判断是否属于已经存在
					param.setChecked(CollUtil.isNotEmpty(menuIdList) && menuIdList.contains(sysResource.getId()));
				}
				list.add(param);
			}
		}
		return list;
	}

	@Override
	public Permission getPermissionById(Integer id) {
		return permissionMapper.selectById(id);
	}
}
