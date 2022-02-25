package com.hong.mapper;


import com.hong.domain.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 参数配置表(Config)表数据库访问层
 *
 * @author hong
 * @since 2022-02-08 23:56:38
 */
@Mapper 
public interface ConfigMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param config 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Config> queryAllByLimit(Config config, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param config 查询条件
     * @return 总行数
     */
    long count(Config config);

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int insert(Config config);
    
        /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int insertSelective(Config config);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Config> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Config> 实例对象列表
     * @return 影响行数
     * throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Config> entities);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int update(Config config);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 查询参数配置信息
     *
     * @param config 参数配置信息
     * @return 参数配置信息
     */
    public Config selectConfig(Config config);

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    public List<Config> selectConfigList(Config config);

    /**
     * 批量删除参数配置
     *
     * @param configIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteConfigByIds(String[] configIds);

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    public Config checkConfigKeyUnique(String configKey);

}

