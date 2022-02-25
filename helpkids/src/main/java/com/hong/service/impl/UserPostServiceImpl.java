package com.hong.service.impl;

import com.hong.domain.UserPost;
import com.hong.mapper.UserPostMapper;
import com.hong.service.UserPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户与岗位关联表(UserPost)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:03:17
 */
@Service
public class UserPostServiceImpl implements UserPostService {
    @Resource
    private UserPostMapper userPostMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserPost queryById(Long id) {
        return this.userPostMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userPost 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserPost> queryByPage(UserPost userPost, PageRequest pageRequest) {
        long total = this.userPostMapper.count(userPost);
        return new PageImpl<>(this.userPostMapper.queryAllByLimit(userPost, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    @Override
    public UserPost insert(UserPost userPost) {
        this.userPostMapper.insert(userPost);
        return userPost;
    }
    
    /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    @Override
    public UserPost insertSelective(UserPost userPost) {
        this.userPostMapper.insertSelective(userPost);
        return userPost;
    }
    

    /**
     * 修改数据
     *
     * @param userPost 实例对象
     * @return 实例对象
     */
    @Override
    public UserPost update(UserPost userPost) {
        this.userPostMapper.update(userPost);
        return this.queryById(userPost.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userPostMapper.deleteById(id) > 0;
    }
}
