package com.hong.service;

import com.hong.domain.OperLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 操作日志记录(OperLog)表服务接口
 *
 * @author hong
 * @since 2022-02-09 00:00:24
 */
public interface OperLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OperLog queryById(Long id);

    /**
     * 分页查询
     *
     * @param operLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<OperLog> queryByPage(OperLog operLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    OperLog insert(OperLog operLog);
    
        /**
     * 新增数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    OperLog insertSelective(OperLog operLog);

    /**
     * 修改数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    OperLog update(OperLog operLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
