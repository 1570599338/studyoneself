package com.hong.mapper;


import com.hong.domain.RoleDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 角色和部门关联表(RoleDept)表数据库访问层
 *
 * @author hong
 * @since 2022-02-09 00:01:36
 */
@Mapper 
public interface RoleDeptMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleDept queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param roleDept 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RoleDept> queryAllByLimit(RoleDept roleDept, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param roleDept 查询条件
     * @return 总行数
     */
    long count(RoleDept roleDept);

    /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 影响行数
     */
    int insert(RoleDept roleDept);
    
        /**
     * 新增数据
     *
     * @param roleDept 实例对象
     * @return 影响行数
     */
    int insertSelective(RoleDept roleDept);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleDept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoleDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoleDept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RoleDept> entities);

    /**
     * 修改数据
     *
     * @param roleDept 实例对象
     * @return 影响行数
     */
    int update(RoleDept roleDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过角色ID删除角色和部门关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

}

