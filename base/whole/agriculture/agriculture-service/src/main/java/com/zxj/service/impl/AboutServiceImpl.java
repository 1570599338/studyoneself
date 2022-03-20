package com.zxj.service.impl;

import com.zxj.common.shiro.ShiroUtils;
import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import com.zxj.domain.About;
import com.zxj.mapper.AboutMapper;
import com.zxj.service.IAboutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 关于我们Service业务层处理
 *
 * @author
 * @date 2022-02-21
 */
@Service
public class AboutServiceImpl implements IAboutService {

    @Resource
    private AboutMapper aboutMapper;

    /**
     * 查询关于我们
     *
     * @param id 关于我们ID
     * @return 关于我们
     */
    @Override
    public About selectAboutById(Integer id) {
        return aboutMapper.selectAboutById(id);
    }

    /**
     * 查询关于我们列表
     *
     * @param about 关于我们
     * @return 关于我们
     */
    @Override
    public List<About> selectAboutList(About about) {
        return aboutMapper.selectAboutList(about);
    }

    /**
     * 新增关于我们
     *
     * @param about 关于我们
     * @return 结果
     */
    @Override
    public int insertAbout(About about) {
        about.setCreateTime(DateUtils.getNowDate());
        about.setCreateBy(ShiroUtils.getLoginName());
        return aboutMapper.insertAbout(about);
    }

    /**
     * 修改关于我们
     *
     * @param about 关于我们
     * @return 结果
     */
    @Override
    public int updateAbout(About about) {
        about.setUpdateTime(DateUtils.getNowDate());
        about.setUpdateBy(ShiroUtils.getLoginName());
        return aboutMapper.updateAbout(about);
    }

    /**
     * 删除关于我们对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAboutByIds(String ids) {
        return aboutMapper.deleteAboutByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关于我们信息
     *
     * @param id 关于我们ID
     * @return 结果
     */
    @Override
    public int deleteAboutById(Integer id) {
        return aboutMapper.deleteAboutById(id);
    }
}
