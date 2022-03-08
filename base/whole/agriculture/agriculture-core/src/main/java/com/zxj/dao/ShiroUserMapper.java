package com.zxj.dao;


import com.zxj.domain.ShiroUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ShiroUser)表数据库访问层
 *
 * @author lquan
 * @since 2022-03-08 19:37:52
 */
@Mapper 
public interface ShiroUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShiroUser queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param shiroUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ShiroUser> queryAllByLimit(ShiroUser shiroUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shiroUser 查询条件
     * @return 总行数
     */
    long count(ShiroUser shiroUser);

    /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 影响行数
     */
    int insert(ShiroUser shiroUser);
    
        /**
     * 新增数据
     *
     * @param shiroUser 实例对象
     * @return 影响行数
     */
    int insertSelective(ShiroUser shiroUser);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiroUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShiroUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShiroUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShiroUser> entities);

    /**
     * 修改数据
     *
     * @param shiroUser 实例对象
     * @return 影响行数
     */
    int update(ShiroUser shiroUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<ShiroUser> queryByname(ShiroUser shiroUser);


}

