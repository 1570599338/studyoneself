package com.zxj.shop.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select r.* from sys_user_role ur,sys_role r where ur.role_id = r.id and ur.user_id=#{userId}")
    List<Role> getUserRoles(String userId);


    @Insert({"delete from sys_user_role where role_id=#{roleId}" })
    int deleteUserRole(Integer roleId);

    @Insert({"delete from sys_role_permission where role_id=#{roleId}" })
    int deleteRolePermission(Integer roleId);



}
