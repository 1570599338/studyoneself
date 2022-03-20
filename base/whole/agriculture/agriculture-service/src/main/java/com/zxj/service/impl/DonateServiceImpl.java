package com.zxj.service.impl;

import java.util.List;

import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxj.mapper.DonateMapper;
import com.zxj.domain.Donate;
import com.zxj.service.IDonateService;

import javax.annotation.Resource;

/**
 * 捐款Service业务层处理
 *
 * @author zxj
 * @date 2022-03-20
 */
@Service
public class DonateServiceImpl implements IDonateService {
    @Resource
    private DonateMapper donateMapper;

    /**
     * 查询捐款
     *
     * @param id 捐款ID
     * @return 捐款
     */
    @Override
    public Donate selectDonateById(Integer id) {
        return donateMapper.selectDonateById(id);
    }

    /**
     * 查询捐款列表
     *
     * @param donate 捐款
     * @return 捐款
     */
    @Override
    public List<Donate> selectDonateList(Donate donate) {
        return donateMapper.selectDonateList(donate);
    }

    /**
     * 新增捐款
     *
     * @param donate 捐款
     * @return 结果
     */
    @Override
    public int insertDonate(Donate donate) {
        donate.setCreateTime(DateUtils.getNowDate());
        return donateMapper.insertDonate(donate);
    }

    /**
     * 修改捐款
     *
     * @param donate 捐款
     * @return 结果
     */
    @Override
    public int updateDonate(Donate donate) {
        return donateMapper.updateDonate(donate);
    }

    /**
     * 删除捐款对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDonateByIds(String ids) {
        return donateMapper.deleteDonateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除捐款信息
     *
     * @param id 捐款ID
     * @return 结果
     */
    @Override
    public int deleteDonateById(Integer id) {
        return donateMapper.deleteDonateById(id);
    }
}
