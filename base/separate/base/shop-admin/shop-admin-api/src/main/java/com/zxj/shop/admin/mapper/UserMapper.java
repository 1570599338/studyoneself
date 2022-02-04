package com.zxj.shop.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxj.shop.admin.entity.User;
import com.zxj.shop.admin.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper extends BaseMapper<User> {

    @Select("select * from sys_user where mobile=#{mobile}")
    User findByUserMobile(@Param("mobile") String mobile);

    @Insert({"insert into sys_user_role(user_id,role_id) values(#{userId}, #{roleId})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createUserRole(UserRole userRole);

    @Insert({"delete from sys_user_role where user_id=#{userId}" })
    int deleteUserRole(UserRole userRole);




}
