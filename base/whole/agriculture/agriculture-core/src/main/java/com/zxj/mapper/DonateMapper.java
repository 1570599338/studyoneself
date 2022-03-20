package com.zxj.mapper;

import com.zxj.domain.Donate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 捐款Mapper接口
 *
 * @author zxj
 * @date 2022-03-20
 */
@Mapper
public interface DonateMapper {
    /**
     * 查询捐款
     *
     * @param id 捐款ID
     * @return 捐款
     */
    public Donate selectDonateById(Integer id);

    /**
     * 查询捐款列表
     *
     * @param donate 捐款
     * @return 捐款集合
     */
    public List<Donate> selectDonateList(Donate donate);

    /**
     * 新增捐款
     *
     * @param donate 捐款
     * @return 结果
     */
    public int insertDonate(Donate donate);

    /**
     * 修改捐款
     *
     * @param donate 捐款
     * @return 结果
     */
    public int updateDonate(Donate donate);

    /**
     * 删除捐款
     *
     * @param id 捐款ID
     * @return 结果
     */
    public int deleteDonateById(Integer id);

    /**
     * 批量删除捐款
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDonateByIds(String[] ids);
}
