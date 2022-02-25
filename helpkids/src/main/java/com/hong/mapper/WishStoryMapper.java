package com.hong.mapper;

import com.hong.domain.WishStory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 圆梦故事Mapper接口
 *
 * @author hong
 * @date 2022-02-24
 */
@Mapper
public interface WishStoryMapper {
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
     * 删除圆梦故事
     *
     * @param id 圆梦故事ID
     * @return 结果
     */
    public int deleteWishStoryById(Integer id);

    /**
     * 批量删除圆梦故事
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWishStoryByIds(String[] ids);
}
