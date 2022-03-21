package com.zxj.service;

import com.zxj.domain.Activity;

import java.util.List;

/**
 * 惠农之路Service接口
 *
 * @author zxj
 * @date 2022-03-21
 */
public interface IActivityService {
    /**
     * 查询惠农之路
     *
     * @param id 惠农之路ID
     * @return 惠农之路
     */
    public Activity selectActivityById(Integer id);

    /**
     * 查询惠农之路列表
     *
     * @param activity 惠农之路
     * @return 惠农之路集合
     */
    public List<Activity> selectActivityList(Activity activity);

    /**
     * 新增惠农之路
     *
     * @param activity 惠农之路
     * @return 结果
     */
    public int insertActivity(Activity activity);

    /**
     * 修改惠农之路
     *
     * @param activity 惠农之路
     * @return 结果
     */
    public int updateActivity(Activity activity);

    /**
     * 批量删除惠农之路
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActivityByIds(String ids);

    /**
     * 删除惠农之路信息
     *
     * @param id 惠农之路ID
     * @return 结果
     */
    public int deleteActivityById(Integer id);
}
