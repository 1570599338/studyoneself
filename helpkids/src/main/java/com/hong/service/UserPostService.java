package com.hong.service;

import com.hong.domain.UserPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户与岗位关联表(UserPost)表服务接口
 *
 * @author hong
 * @since 2022-02-09 00:03:17
 */
public interface UserPostService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserPost queryById(Long id);

    /**
     * 分页查询
     *
     * @param userPost 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserPost> queryByPage(UserPost userPost, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    UserPost insert(UserPost userPost);
    
        /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    UserPost insertSelective(UserPost userPost);

    /**
     * 修改数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    UserPost update(UserPost userPost);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
