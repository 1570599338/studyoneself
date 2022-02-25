package com.hong.mapper;


import com.hong.domain.DictData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 字典数据表(DictData)表数据库访问层
 *
 * @author hong
 * @since 2022-02-08 23:58:30
 */
@Mapper 
public interface DictDataMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictData queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param dictData 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DictData> queryAllByLimit(DictData dictData, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dictData 查询条件
     * @return 总行数
     */
    long count(DictData dictData);

    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 影响行数
     */
    int insert(DictData dictData);
    
        /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 影响行数
     */
    int insertSelective(DictData dictData);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictData> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DictData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DictData> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DictData> entities);

    /**
     * 修改数据
     *
     * @param dictData 实例对象
     * @return 影响行数
     */
    int update(DictData dictData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);


    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataList(DictData dictData);


    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    public int deleteDictDataByIds(String[] ids);

    /**
     * 同步修改字典类型
     *
     * @param oldDictType 旧字典类型
     * @param newDictType 新旧字典类型
     * @return 结果
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    /**
     * 查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据
     */
    public int countDictDataByType(String dictType);


    /**
     * 批量删除字典类型
     *
     * @param ids 需要删除的数据
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteDictTypeByIds(String ids);


}

