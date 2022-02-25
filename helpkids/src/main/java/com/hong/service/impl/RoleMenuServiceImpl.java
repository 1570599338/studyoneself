package com.hong.service.impl;

import com.hong.domain.RoleMenu;
import com.hong.mapper.RoleMenuMapper;
import com.hong.service.RoleMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色和菜单关联表(RoleMenu)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:01:55
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleMenu queryById(Long id) {
        return this.roleMenuMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleMenu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RoleMenu> queryByPage(RoleMenu roleMenu, PageRequest pageRequest) {
        long total = this.roleMenuMapper.count(roleMenu);
        return new PageImpl<>(this.roleMenuMapper.queryAllByLimit(roleMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu insert(RoleMenu roleMenu) {
        this.roleMenuMapper.insert(roleMenu);
        return roleMenu;
    }
    
    /**
     * 新增数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu insertSelective(RoleMenu roleMenu) {
        this.roleMenuMapper.insertSelective(roleMenu);
        return roleMenu;
    }
    

    /**
     * 修改数据
     *
     * @param roleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public RoleMenu update(RoleMenu roleMenu) {
        this.roleMenuMapper.update(roleMenu);
        return this.queryById(roleMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleMenuMapper.deleteById(id) > 0;
    }
}
