package com.zxj.service.impl;

import java.util.List;

import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxj.mapper.ApplyMapper;
import com.zxj.domain.Apply;
import com.zxj.service.IApplyService;

import javax.annotation.Resource;

/**
 * 申请Service业务层处理
 * 
 * @author zxj
 * @date 2022-03-20
 */
@Service
public class ApplyServiceImpl implements IApplyService 
{
    @Resource
    private ApplyMapper applyMapper;

    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    @Override
    public Apply selectApplyById(Integer id)
    {
        return applyMapper.selectApplyById(id);
    }

    /**
     * 查询申请列表
     * 
     * @param apply 申请
     * @return 申请
     */
    @Override
    public List<Apply> selectApplyList(Apply apply)
    {
        return applyMapper.selectApplyList(apply);
    }

    /**
     * 新增申请
     * 
     * @param apply 申请
     * @return 结果
     */
    @Override
    public int insertApply(Apply apply)
    {
        apply.setCreateTime(DateUtils.getNowDate());
        return applyMapper.insertApply(apply);
    }

    /**
     * 修改申请
     * 
     * @param apply 申请
     * @return 结果
     */
    @Override
    public int updateApply(Apply apply)
    {
        apply.setUpdateTime(DateUtils.getNowDate());
        return applyMapper.updateApply(apply);
    }

    /**
     * 删除申请对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteApplyByIds(String ids)
    {
        return applyMapper.deleteApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除申请信息
     * 
     * @param id 申请ID
     * @return 结果
     */
    @Override
    public int deleteApplyById(Integer id)
    {
        return applyMapper.deleteApplyById(id);
    }
}
