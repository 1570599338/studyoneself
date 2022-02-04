package com.zxj.shop.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxj.shop.admin.entity.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("select p.* from sys_role_permission rp , sys_permission p where rp.PERMISSION_ID = p.id AND rp.ROLE_ID = #{roleId}")
    List<Permission> getUserPermission(String roleId);

}
