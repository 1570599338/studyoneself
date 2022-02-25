package com.hong.service.impl;

import com.hong.domain.OperLog;
import com.hong.mapper.OperLogMapper;
import com.hong.service.OperLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志记录(OperLog)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:00:24
 */
@Service
public class OperLogServiceImpl implements OperLogService {
    @Resource
    private OperLogMapper operLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OperLog queryById(Long id) {
        return this.operLogMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param operLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<OperLog> queryByPage(OperLog operLog, PageRequest pageRequest) {
        long total = this.operLogMapper.count(operLog);
        return new PageImpl<>(this.operLogMapper.queryAllByLimit(operLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    @Override
    public OperLog insert(OperLog operLog) {
        this.operLogMapper.insert(operLog);
        return operLog;
    }
    
    /**
     * 新增数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    @Override
    public OperLog insertSelective(OperLog operLog) {
        this.operLogMapper.insertSelective(operLog);
        return operLog;
    }
    

    /**
     * 修改数据
     *
     * @param operLog 实例对象
     * @return 实例对象
     */
    @Override
    public OperLog update(OperLog operLog) {
        this.operLogMapper.update(operLog);
        return this.queryById(operLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.operLogMapper.deleteById(id) > 0;
    }
}
