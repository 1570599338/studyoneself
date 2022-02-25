package com.hong.service.impl;

import com.hong.common.shiro.ShiroUtils;
import com.hong.common.text.Convert;
import com.hong.common.utils.DateUtils;
import com.hong.domain.WishStory;
import com.hong.mapper.WishStoryMapper;
import com.hong.service.IWishStoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 圆梦故事Service业务层处理
 *
 * @author hong
 * @date 2022-02-24
 */
@Service
public class WishStoryServiceImpl implements IWishStoryService {
    @Resource
    private WishStoryMapper wishStoryMapper;

    /**
     * 查询圆梦故事
     *
     * @param id 圆梦故事ID
     * @return 圆梦故事
     */
    @Override
    public WishStory selectWishStoryById(Integer id) {
        return wishStoryMapper.selectWishStoryById(id);
    }

    /**
     * 查询圆梦故事列表
     *
     * @param wishStory 圆梦故事
     * @return 圆梦故事
     */
    @Override
    public List<WishStory> selectWishStoryList(WishStory wishStory) {
        return wishStoryMapper.selectWishStoryList(wishStory);
    }

    /**
     * 新增圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    @Override
    public int insertWishStory(WishStory wishStory) {
        wishStory.setCreateTime(DateUtils.getNowDate());
        return wishStoryMapper.insertWishStory(wishStory);
    }

    /**
     * 修改圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    @Override
    public int updateWishStory(WishStory wishStory) {
        wishStory.setUpdateTime(DateUtils.getNowDate());
        wishStory.setUpdateBy(ShiroUtils.getLoginName());
        return wishStoryMapper.updateWishStory(wishStory);
    }

    /**
     * 删除圆梦故事对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWishStoryByIds(String ids) {
        return wishStoryMapper.deleteWishStoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除圆梦故事信息
     *
     * @param id 圆梦故事ID
     * @return 结果
     */
    @Override
    public int deleteWishStoryById(Integer id) {
        return wishStoryMapper.deleteWishStoryById(id);
    }
}
