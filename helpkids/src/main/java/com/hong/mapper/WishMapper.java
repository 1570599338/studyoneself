package com.hong.mapper;

import com.hong.domain.Wish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 关于我们Mapper接口
 *
 * @author hong
 * @date 2022-02-21
 */
@Mapper
public interface WishMapper {
    /**
     * 查询关于我们
     *
     * @param id 关于我们ID
     * @return 关于我们
     */
    public Wish selectWishById(Integer id);

    /**
     * 查询关于我们列表
     *
     * @param wish 关于我们
     * @return 关于我们集合
     */
    public List<Wish> selectWishList(Wish wish);

    /**
     * 新增关于我们
     *
     * @param wish 关于我们
     * @return 结果
     */
    public int insertWish(Wish wish);

    /**
     * 修改关于我们
     *
     * @param wish 关于我们
     * @return 结果
     */
    public int updateWish(Wish wish);

    /**
     * 删除关于我们
     *
     * @param id 关于我们ID
     * @return 结果
     */
    public int deleteWishById(Integer id);

    /**
     * 批量删除关于我们
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWishByIds(String[] ids);
}
