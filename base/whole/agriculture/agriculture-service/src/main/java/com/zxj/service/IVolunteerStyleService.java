package com.zxj.service;

import com.zxj.domain.VolunteerStyle;

import java.util.List;

/**
 * 志愿者风采Service接口
 *
 * @author zxj
 * @date 2022-03-20
 */
public interface IVolunteerStyleService {
    /**
     * 查询志愿者风采
     *
     * @param id 志愿者风采ID
     * @return 志愿者风采
     */
    public VolunteerStyle selectVolunteerStyleById(Integer id);

    /**
     * 查询志愿者风采列表
     *
     * @param volunteerStyle 志愿者风采
     * @return 志愿者风采集合
     */
    public List<VolunteerStyle> selectVolunteerStyleList(VolunteerStyle volunteerStyle);

    /**
     * 新增志愿者风采
     *
     * @param volunteerStyle 志愿者风采
     * @return 结果
     */
    public int insertVolunteerStyle(VolunteerStyle volunteerStyle);

    /**
     * 修改志愿者风采
     *
     * @param volunteerStyle 志愿者风采
     * @return 结果
     */
    public int updateVolunteerStyle(VolunteerStyle volunteerStyle);

    /**
     * 批量删除志愿者风采
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVolunteerStyleByIds(String ids);

    /**
     * 删除志愿者风采信息
     *
     * @param id 志愿者风采ID
     * @return 结果
     */
    public int deleteVolunteerStyleById(Integer id);
}
