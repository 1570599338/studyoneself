package com.hong.service;

import com.hong.domain.RoleDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色和部门关联表(RoleDept)表服务接口
 *
 * @author hong
 * @since 2022-02-09 00:01:36
 */
public interface RoleDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleDept queryById(Long id);

    /**
     * 分页查询
     *
     * @param roleDept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RoleDept> queryByPage(RoleDept roleDept, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    RoleDept insert(RoleDept roleDept);
    
        /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    RoleDept insertSelective(RoleDept roleDept);

    /**
     * 修改数据
     *
     * @param roleDept 实例对象
     * @return 实例对象
     */
    RoleDept update(RoleDept roleDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
