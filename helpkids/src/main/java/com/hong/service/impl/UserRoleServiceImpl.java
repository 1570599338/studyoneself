package com.hong.service.impl;

import com.hong.domain.UserRole;
import com.hong.mapper.UserRoleMapper;
import com.hong.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户和角色关联表(UserRole)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:03:47
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Long id) {
        return this.userRoleMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest) {
        long total = this.userRoleMapper.count(userRole);
        return new PageImpl<>(this.userRoleMapper.queryAllByLimit(userRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleMapper.insert(userRole);
        return userRole;
    }
    
    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insertSelective(UserRole userRole) {
        this.userRoleMapper.insertSelective(userRole);
        return userRole;
    }
    

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleMapper.update(userRole);
        return this.queryById(userRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userRoleMapper.deleteById(id) > 0;
    }
}
