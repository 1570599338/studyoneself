package com.hong.service;

import com.hong.bean.Resp.Ztree;
import com.hong.domain.Dept;
import com.hong.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 部门表(Dept)表服务接口
 *
 * @author hong
 * @since 2022-02-08 23:58:06
 */
public interface DeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dept queryById(Long id);

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Dept> queryByPage(Dept dept, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insert(Dept dept);
    
        /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insertSelective(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept update(Dept dept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    public List<Dept> selectDeptList(Dept dept);


    /**
     * 查询部门管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectDeptTree(Dept dept);


    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(Role role);


}
