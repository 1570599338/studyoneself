package com.hong.service.impl;

import com.hong.bean.Resp.Ztree;
import com.hong.common.UserConstants;
import com.hong.common.shiro.ShiroUtils;
import com.hong.common.text.Convert;
import com.hong.common.utils.StringUtils;
import com.hong.domain.DictType;
import com.hong.mapper.DictDataMapper;
import com.hong.mapper.DictTypeMapper;
import com.hong.service.DictTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 字典类型表(DictType)表服务实现类
 *
 * @author hong
 * @since 2022-02-08 23:58:49
 */
@Service
public class DictTypeServiceImpl implements DictTypeService {
    @Resource
    private DictTypeMapper dictTypeMapper;

    @Resource
    private DictDataMapper dictDataMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DictType queryById(Long id) {
        return this.dictTypeMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dictType    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<DictType> queryByPage(DictType dictType, PageRequest pageRequest) {
        long total = this.dictTypeMapper.count(dictType);
        return new PageImpl<>(this.dictTypeMapper.queryAllByLimit(dictType, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType insert(DictType dictType) {
        this.dictTypeMapper.insert(dictType);
        return dictType;
    }

    /**
     * 新增数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType insertSelective(DictType dictType) {
        this.dictTypeMapper.insertSelective(dictType);
        return dictType;
    }


    /**
     * 修改数据
     *
     * @param dictType 实例对象
     * @return 实例对象
     */
    @Override
    public DictType update(DictType dictType) {
        this.dictTypeMapper.update(dictType);
        return this.queryById(dictType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dictTypeMapper.deleteById(id) > 0;
    }

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    @Override
    public List<DictType> selectDictTypeList(DictType dictType) {
        return dictTypeMapper.selectDictTypeList(dictType);
    }


    /**
     * 校验字典类型称是否唯一
     *
     * @param dict 字典类型
     * @return 结果
     */
    @Override
    public String checkDictTypeUnique(DictType dict) {
        Long dictId = StringUtils.isNull(dict.getId()) ? -1L : dict.getId();
        DictType dictType = dictTypeMapper.checkDictTypeUnique(dict.getDictType());
        if (StringUtils.isNotNull(dictType) && dictType.getId().longValue() != dictId.longValue()) {
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }

    /**
     * 新增保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    public int insertDictType(DictType dictType) {
        dictType.setCreateBy(ShiroUtils.getLoginName());
        dictType.setCreateTime(new Date());
        return dictTypeMapper.insertSelective(dictType);
    }


    /**
     * 修改保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDictType(DictType dictType) {
        dictType.setUpdateBy(ShiroUtils.getLoginName());
        DictType oldDict = dictTypeMapper.queryById(dictType.getId());
        dictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
        dictType.setUpdateTime(new Date());
        return dictTypeMapper.update(dictType);
    }


    /**
     * 批量删除字典类型
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictTypeByIds(String ids) {
        Long[] dictIds = Convert.toLongArray(ids);
        for (Long dictId : dictIds) {
            DictType dictType = dictTypeMapper.queryById(dictId);
            if (dictDataMapper.countDictDataByType(dictType.getDictType()) > 0) {
                throw new RuntimeException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
        }

        return dictTypeMapper.deleteDictTypeByIds(dictIds);
    }

    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    @Override
    public List<DictType> selectDictTypeAll() {
        return dictTypeMapper.selectDictTypeAll();
    }

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    public DictType selectDictTypeByType(String dictType) {
        return dictTypeMapper.selectDictTypeByType(dictType);
    }

    /**
     * 查询字典类型树
     *
     * @param dictType 字典类型
     * @return 所有字典类型
     */
    public List<Ztree> selectDictTree(DictType dictType) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<DictType> dictList = dictTypeMapper.selectDictTypeList(dictType);
        for (DictType dict : dictList) {
            if (UserConstants.DICT_NORMAL.equals(dict.getStatus())) {
                Ztree ztree = new Ztree();
                ztree.setId(dict.getId());
                ztree.setName(transDictName(dict));
                ztree.setTitle(dict.getDictType());
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

    public String transDictName(DictType dictType) {
        StringBuffer sb = new StringBuffer();
        sb.append("(" + dictType.getDictName() + ")");
        sb.append("&nbsp;&nbsp;&nbsp;" + dictType.getDictType());
        return sb.toString();
    }
}
