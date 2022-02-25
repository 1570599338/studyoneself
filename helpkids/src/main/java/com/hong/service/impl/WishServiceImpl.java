package com.hong.service.impl;

import com.hong.common.shiro.ShiroUtils;
import com.hong.common.text.Convert;
import com.hong.common.utils.Constants;
import com.hong.common.utils.DateUtils;
import com.hong.domain.Wish;
import com.hong.mapper.UserMapper;
import com.hong.mapper.WishMapper;
import com.hong.service.IWishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 关于我们Service业务层处理
 *
 * @author hong
 * @date 2022-02-21
 */
@Service
public class WishServiceImpl implements IWishService {

    @Resource
    private WishMapper wishMapper;

    @Resource
    private UserMapper userMapper;

    /**
     * 查询关于我们
     *
     * @param id 关于我们ID
     * @return 关于我们
     */
    @Override
    public Wish selectWishById(Integer id) {
        return wishMapper.selectWishById(id);
    }

    /**
     * 查询关于我们列表
     *
     * @param wish 关于我们
     * @return 关于我们
     */
    @Override
    public List<Wish> selectWishList(Wish wish) {

        List<Wish> list  = wishMapper.selectWishList(wish);
        List<Wish> result_list  = new ArrayList<>();
        for (Wish bean:list){
            if(bean!=null && bean.getAuditId()!=null)
                bean.setAuditName(userMapper.queryById(bean.getAuditId().longValue()).getLoginName());
            result_list.add(bean);
        }

        return result_list;
    }

    /**
     * 新增关于我们
     *
     * @param wish 关于我们
     * @return 结果
     */
    @Override
    public int insertWish(Wish wish) {
        wish.setCreateTime(DateUtils.getNowDate());
        wish.setCreateBy(ShiroUtils.getLoginName());
        wish.setUserId(ShiroUtils.getUserId().intValue());
        // 审核状态
        wish.setAuditStatus(Constants.audit_init);
        return wishMapper.insertWish(wish);
    }

    /**
     * 修改关于我们
     *
     * @param wish 关于我们
     * @return 结果
     */
    @Override
    public int updateWish(Wish wish) {
        wish.setUpdateTime(DateUtils.getNowDate());
        wish.setUpdateBy(ShiroUtils.getLoginName());
        return wishMapper.updateWish(wish);
    }

    /**
     * 删除关于我们对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWishByIds(String ids) {
        return wishMapper.deleteWishByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关于我们信息
     *
     * @param id 关于我们ID
     * @return 结果
     */
    @Override
    public int deleteWishById(Integer id) {
        return wishMapper.deleteWishById(id);
    }
}
