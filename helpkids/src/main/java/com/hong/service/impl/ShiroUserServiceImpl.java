package com.hong.service.impl;

import com.hong.domain.ShiroUser;
import com.hong.mapper.ShiroUserMapper;
import com.hong.service.ShiroUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (ShiroUser)表服务实现类
 *
 * @author hong
 * @since 2022-02-02 01:41:58
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService {
    @Resource
    private ShiroUserMapper shiroUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShiroUser queryById(String id) {
        return this.shiroUserMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shiroUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ShiroUser> queryByPage(ShiroUser shiroUser, PageRequest pageRequest) {
        long total = this.shiroUserMapper.count(shiroUser);
        return new PageImpl<>(this.shiroUserMapper.queryAllByLimit(shiroUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser insert(ShiroUser shiroUser) {
        this.shiroUserMapper.insert(shiroUser);
        return shiroUser;
    }
    
    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser insertSelective(ShiroUser shiroUser) {
        this.shiroUserMapper.insertSelective(shiroUser);
        return shiroUser;
    }
    

    /**
     * 修改数据
     *
     * @param shiroUser 实例对象
     * @return 实例对象
     */
    @Override
    public ShiroUser update(ShiroUser shiroUser) {
        this.shiroUserMapper.update(shiroUser);
        return this.queryById(shiroUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.shiroUserMapper.deleteById(id) > 0;
    }
}
