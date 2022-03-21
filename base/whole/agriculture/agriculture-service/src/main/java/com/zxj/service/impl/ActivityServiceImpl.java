package com.zxj.service.impl;

import java.util.List;

import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxj.mapper.ActivityMapper;
import com.zxj.domain.Activity;
import com.zxj.service.IActivityService;

import javax.annotation.Resource;

/**
 * 惠农之路Service业务层处理
 *
 * @author zxj
 * @date 2022-03-21
 */
@Service
public class ActivityServiceImpl implements IActivityService {
    @Resource
    private ActivityMapper activityMapper;

    /**
     * 查询惠农之路
     *
     * @param id 惠农之路ID
     * @return 惠农之路
     */
    @Override
    public Activity selectActivityById(Integer id) {
        return activityMapper.selectActivityById(id);
    }

    /**
     * 查询惠农之路列表
     *
     * @param activity 惠农之路
     * @return 惠农之路
     */
    @Override
    public List<Activity> selectActivityList(Activity activity) {
        return activityMapper.selectActivityList(activity);
    }

    /**
     * 新增惠农之路
     *
     * @param activity 惠农之路
     * @return 结果
     */
    @Override
    public int insertActivity(Activity activity) {
        activity.setCreateTime(DateUtils.getNowDate());
        return activityMapper.insertActivity(activity);
    }

    /**
     * 修改惠农之路
     *
     * @param activity 惠农之路
     * @return 结果
     */
    @Override
    public int updateActivity(Activity activity) {
        activity.setUpdateTime(DateUtils.getNowDate());
        return activityMapper.updateActivity(activity);
    }

    /**
     * 删除惠农之路对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActivityByIds(String ids) {
        return activityMapper.deleteActivityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除惠农之路信息
     *
     * @param id 惠农之路ID
     * @return 结果
     */
    @Override
    public int deleteActivityById(Integer id) {
        return activityMapper.deleteActivityById(id);
    }
}
