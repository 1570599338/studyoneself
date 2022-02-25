package com.hong.mapper;


import com.hong.domain.UserPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户与岗位关联表(UserPost)表数据库访问层
 *
 * @author hong
 * @since 2022-02-09 00:03:17
 */
@Mapper 
public interface UserPostMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserPost queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param userPost 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UserPost> queryAllByLimit(UserPost userPost, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userPost 查询条件
     * @return 总行数
     */
    long count(UserPost userPost);

    /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 影响行数
     */
    int insert(UserPost userPost);
    
        /**
     * 新增数据
     *
     * @param userPost 实例对象
     * @return 影响行数
     */
    int insertSelective(UserPost userPost);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserPost> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserPost> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserPost> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserPost> entities);

    /**
     * 修改数据
     *
     * @param userPost 实例对象
     * @return 影响行数
     */
    int update(UserPost userPost);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过用户ID删除用户和岗位关联
     *
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserPostByUserId(Long userId);

}

