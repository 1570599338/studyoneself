package com.zxj.service;

import com.zxj.domain.ShiroUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ShiroUser)表服务接口
 *
 * @author lquan
 * @since 2022-03-08 19:38:19
 */
public interface ShiroUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiroUser queryById(String id);

    /**
     * 分页查询
     *
     * @param shiroUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ShiroUser> queryByPage(ShiroUser shiroUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser insert(ShiroUser shiroUser);
    
        /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser insertSelective(ShiroUser shiroUser);

    /**
     * 修改数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    ShiroUser update(ShiroUser shiroUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
