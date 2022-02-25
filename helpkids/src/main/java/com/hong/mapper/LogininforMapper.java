package com.hong.mapper;


import com.hong.domain.Logininfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 系统访问记录(Logininfor)表数据库访问层
 *
 * @author hong
 * @since 2022-02-08 23:59:12
 */
@Mapper 
public interface LogininforMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Logininfor queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param logininfor 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Logininfor> queryAllByLimit(Logininfor logininfor, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param logininfor 查询条件
     * @return 总行数
     */
    long count(Logininfor logininfor);

    /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 影响行数
     */
    int insert(Logininfor logininfor);
    
        /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 影响行数
     */
    int insertSelective(Logininfor logininfor);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Logininfor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Logininfor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Logininfor> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Logininfor> entities);

    /**
     * 修改数据
     *
     * @param logininfor 实例对象
     * @return 影响行数
     */
    int update(Logininfor logininfor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

