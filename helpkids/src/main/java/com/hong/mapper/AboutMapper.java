package com.hong.mapper;

import com.hong.domain.About;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 关于我们Mapper接口
 *
 * @author
 * @date 2022-02-21
 */
@Mapper
public interface AboutMapper {
    /**
     * 查询关于我们
     *
     * @param id 关于我们ID
     * @return 关于我们
     */
    public About selectAboutById(Integer id);

    /**
     * 查询关于我们列表
     *
     * @param about 关于我们
     * @return 关于我们集合
     */
    public List<About> selectAboutList(About about);

    /**
     * 新增关于我们
     *
     * @param about 关于我们
     * @return 结果
     */
    public int insertAbout(About about);

    /**
     * 修改关于我们
     *
     * @param about 关于我们
     * @return 结果
     */
    public int updateAbout(About about);

    /**
     * 删除关于我们
     *
     * @param id 关于我们ID
     * @return 结果
     */
    public int deleteAboutById(Integer id);

    /**
     * 批量删除关于我们
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAboutByIds(String[] ids);
}
