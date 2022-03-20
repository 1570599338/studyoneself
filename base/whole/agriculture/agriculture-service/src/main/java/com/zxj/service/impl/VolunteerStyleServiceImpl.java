package com.zxj.service.impl;

import java.util.List;

import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxj.mapper.VolunteerStyleMapper;
import com.zxj.domain.VolunteerStyle;
import com.zxj.service.IVolunteerStyleService;

import javax.annotation.Resource;


/**
 * 志愿者风采Service业务层处理
 *
 * @author zxj
 * @date 2022-03-20
 */
@Service
public class VolunteerStyleServiceImpl implements IVolunteerStyleService {
    @Resource
    private VolunteerStyleMapper volunteerStyleMapper;

    /**
     * 查询志愿者风采
     *
     * @param id 志愿者风采ID
     * @return 志愿者风采
     */
    @Override
    public VolunteerStyle selectVolunteerStyleById(Integer id) {
        return volunteerStyleMapper.selectVolunteerStyleById(id);
    }

    /**
     * 查询志愿者风采列表
     *
     * @param volunteerStyle 志愿者风采
     * @return 志愿者风采
     */
    @Override
    public List<VolunteerStyle> selectVolunteerStyleList(VolunteerStyle volunteerStyle) {
        return volunteerStyleMapper.selectVolunteerStyleList(volunteerStyle);
    }

    /**
     * 新增志愿者风采
     *
     * @param volunteerStyle 志愿者风采
     * @return 结果
     */
    @Override
    public int insertVolunteerStyle(VolunteerStyle volunteerStyle) {
        volunteerStyle.setCreateTime(DateUtils.getNowDate());
        return volunteerStyleMapper.insertVolunteerStyle(volunteerStyle);
    }

    /**
     * 修改志愿者风采
     *
     * @param volunteerStyle 志愿者风采
     * @return 结果
     */
    @Override
    public int updateVolunteerStyle(VolunteerStyle volunteerStyle) {
        volunteerStyle.setUpdateTime(DateUtils.getNowDate());
        return volunteerStyleMapper.updateVolunteerStyle(volunteerStyle);
    }

    /**
     * 删除志愿者风采对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVolunteerStyleByIds(String ids) {
        return volunteerStyleMapper.deleteVolunteerStyleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除志愿者风采信息
     *
     * @param id 志愿者风采ID
     * @return 结果
     */
    @Override
    public int deleteVolunteerStyleById(Integer id) {
        return volunteerStyleMapper.deleteVolunteerStyleById(id);
    }
}
