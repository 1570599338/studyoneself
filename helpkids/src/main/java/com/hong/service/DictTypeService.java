package com.hong.service;

import com.hong.bean.Resp.Ztree;
import com.hong.domain.DictType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 字典类型表(DictType)表服务接口
 *
 * @author hong
 * @since 2022-02-08 23:58:49
 */
public interface DictTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictType queryById(Long id);

    /**
     * 分页查询
     *
     * @param dictType 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DictType> queryByPage(DictType dictType, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType insert(DictType dictType);
    
        /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType insertSelective(DictType dictType);

    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    DictType update(DictType dictType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    public List<DictType> selectDictTypeList(DictType dictType);

    /**
     * 校验字典类型称是否唯一
     *
     * @param dictType 字典类型
     * @return 结果
     */
    public String checkDictTypeUnique(DictType dictType);


    /**
     * 新增保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    public int insertDictType(DictType dictType);


    /**
     * 修改保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    public int updateDictType(DictType dictType);


    /**
     * 批量删除字典类型
     *
     * @param ids 需要删除的数据
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteDictTypeByIds(String ids);



    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    public List<DictType> selectDictTypeAll();


    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    public DictType selectDictTypeByType(String dictType);

    /**
     * 查询字典类型树
     *
     * @param dictType 字典类型
     * @return 所有字典类型
     */
    public List<Ztree> selectDictTree(DictType dictType);



}
