package com.hong.service.impl;

import com.hong.common.shiro.ShiroUtils;
import com.hong.common.text.Convert;
import com.hong.domain.DictData;
import com.hong.mapper.DictDataMapper;
import com.hong.service.DictDataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 字典数据表(DictData)表服务实现类
 *
 * @author hong
 * @since 2022-02-08 23:58:30
 */
@Service
public class DictDataServiceImpl implements DictDataService {
    @Resource
    private DictDataMapper dictDataMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictData queryById(Long id) {
        return this.dictDataMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dictData    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<DictData> queryByPage(DictData dictData, PageRequest pageRequest) {
        long total = this.dictDataMapper.count(dictData);
        return new PageImpl<>(this.dictDataMapper.queryAllByLimit(dictData, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData insert(DictData dictData) {
        this.dictDataMapper.insert(dictData);
        return dictData;
    }

    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData insertSelective(DictData dictData) {
        this.dictDataMapper.insertSelective(dictData);
        return dictData;
    }


    /**
     * 修改数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    @Override
    public DictData update(DictData dictData) {
        this.dictDataMapper.update(dictData);
        return this.queryById(dictData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictDataMapper.deleteById(id) > 0;
    }

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataByType(String dictType) {
        return dictDataMapper.selectDictDataByType(dictType);
    }


    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return dictDataMapper.selectDictLabel(dictType, dictValue);
    }


    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataList(DictData dictData) {
        return dictDataMapper.selectDictDataList(dictData);
    }


    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(DictData dictData) {
        dictData.setCreateBy(ShiroUtils.getLoginName());
        dictData.setCreateTime(new Date());
        return dictDataMapper.insert(dictData);
    }

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(DictData dictData) {
        dictData.setUpdateBy(ShiroUtils.getLoginName());
        return dictDataMapper.update(dictData);
    }
    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictDataByIds(String ids)
    {
        return dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
    }


}
