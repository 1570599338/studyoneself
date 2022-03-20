package com.zxj.mapper;

import com.zxj.domain.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 申请Mapper接口
 *
 * @author zxj
 * @date 2022-03-20
 */
@Mapper
public interface ApplyMapper {
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
     * 删除申请
     *
     * @param id 申请ID
     * @return 结果
     */
    public int deleteApplyById(Integer id);

    /**
     * 批量删除申请
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApplyByIds(String[] ids);
}
