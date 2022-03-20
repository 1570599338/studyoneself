package com.zxj.service;

import com.zxj.domain.Apply;
import java.util.List;

/**
 * 申请Service接口
 * 
 * @author zxj
 * @date 2022-03-20
 */
public interface IApplyService 
{
    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    public Apply selectApplyById(Integer id);

    /**
     * 查询申请列表
     * 
     * @param apply 申请
     * @return 申请集合
     */
    public List<Apply> selectApplyList(Apply apply);

    /**
     * 新增申请
     * 
     * @param apply 申请
     * @return 结果
     */
    public int insertApply(Apply apply);

    /**
     * 修改申请
     * 
     * @param apply 申请
     * @return 结果
     */
    public int updateApply(Apply apply);

    /**
     * 批量删除申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApplyByIds(String ids);

    /**
     * 删除申请信息
     * 
     * @param id 申请ID
     * @return 结果
     */
    public int deleteApplyById(Integer id);
}
