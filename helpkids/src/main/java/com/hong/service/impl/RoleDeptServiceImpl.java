package com.hong.service.impl;

import com.hong.domain.RoleDept;
import com.hong.mapper.RoleDeptMapper;
import com.hong.service.RoleDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色和部门关联表(RoleDept)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:01:36
 */
@Service
public class RoleDeptServiceImpl implements RoleDeptService {
    @Resource
    private RoleDeptMapper roleDeptMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleDept queryById(Long id) {
        return this.roleDeptMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RoleDept> queryByPage(RoleDept roleDept, PageRequest pageRequest) {
        long total = this.roleDeptMapper.count(roleDept);
        return new PageImpl<>(this.roleDeptMapper.queryAllByLimit(roleDept, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDept insert(RoleDept roleDept) {
        this.roleDeptMapper.insert(roleDept);
        return roleDept;
    }
    
    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDept insertSelective(RoleDept roleDept) {
        this.roleDeptMapper.insertSelective(roleDept);
        return roleDept;
    }
    

    /**
     * 修改数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDept update(RoleDept roleDept) {
        this.roleDeptMapper.update(roleDept);
        return this.queryById(roleDept.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleDeptMapper.deleteById(id) > 0;
    }
}
