package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.SysToken;
import com.zxj.shop.admin.entity.User;

import java.util.Map;

public interface ShiroService extends IService<User> {

    /**
     * find token by token
     * @param accessToken
     * @return
     */
    SysToken findByToken(String accessToken);

    /**
     * find user by userId
     * @param userId
     * @return
     */
    User findByUserId(Integer userId);

    /**
     * Find user by username
     * @param username
     * @return
     */
    User findByUserMobile(String username);

    /**
     * create token by userId
     * @param userId
     * @return
     */
    Map<String,Object> createToken(Integer userId);

    /**
     * logout
     * @param token
     */
    int logout(String token , Integer userId);

    IPage<User> page(Page<User> page, User user);

    int createUser(User user);

    int updateUser(User user);

    User getToken(String token);

    Map<String,Object> view(String token,String userId);

    int updateUserById(User user);

    int locked(User sysAccount);
}
