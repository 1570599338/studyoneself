package com.zxj.shop.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.RolePermission;
import com.zxj.shop.admin.mapper.RolePermissionMapper;
import com.zxj.shop.admin.service.RolePermissionService;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
}
