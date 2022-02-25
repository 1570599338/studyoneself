package com.hong.service;

import com.hong.domain.UserOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 在线用户记录(UserOnline)表服务接口
 *
 * @author hong
 * @since 2022-02-09 00:02:54
 */
public interface UserOnlineService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserOnline queryById(Long id);

    /**
     * 分页查询
     *
     * @param userOnline 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserOnline> queryByPage(UserOnline userOnline, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    UserOnline insert(UserOnline userOnline);
    
        /**
     * 新增数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    UserOnline insertSelective(UserOnline userOnline);

    /**
     * 修改数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    UserOnline update(UserOnline userOnline);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
