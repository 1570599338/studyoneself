package com.hong.service;

import com.hong.domain.WishStory;

import java.util.List;

/**
 * 圆梦故事Service接口
 *
 * @author hong
 * @date 2022-02-24
 */
public interface IWishStoryService {
    /**
     * 查询圆梦故事
     *
     * @param id 圆梦故事ID
     * @return 圆梦故事
     */
    public WishStory selectWishStoryById(Integer id);

    /**
     * 查询圆梦故事列表
     *
     * @param wishStory 圆梦故事
     * @return 圆梦故事集合
     */
    public List<WishStory> selectWishStoryList(WishStory wishStory);

    /**
     * 新增圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    public int insertWishStory(WishStory wishStory);

    /**
     * 修改圆梦故事
     *
     * @param wishStory 圆梦故事
     * @return 结果
     */
    public int updateWishStory(WishStory wishStory);

    /**
     * 批量删除圆梦故事
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWishStoryByIds(String ids);

    /**
     * 删除圆梦故事信息
     *
     * @param id 圆梦故事ID
     * @return 结果
     */
    public int deleteWishStoryById(Integer id);
}
