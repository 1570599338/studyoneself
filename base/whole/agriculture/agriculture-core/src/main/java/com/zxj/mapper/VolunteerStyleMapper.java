package com.zxj.mapper;

import com.zxj.domain.VolunteerStyle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 志愿者风采Mapper接口
 * 
 * @author zxj
 * @date 2022-03-20
 */
@Mapper
public interface VolunteerStyleMapper 
{
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
     * 删除志愿者风采
     * 
     * @param id 志愿者风采ID
     * @return 结果
     */
    public int deleteVolunteerStyleById(Integer id);

    /**
     * 批量删除志愿者风采
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVolunteerStyleByIds(String[] ids);
}
