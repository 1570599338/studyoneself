package com.hong.service.impl;

import com.hong.domain.Logininfor;
import com.hong.mapper.LogininforMapper;
import com.hong.service.LogininforService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统访问记录(Logininfor)表服务实现类
 *
 * @author hong
 * @since 2022-02-08 23:59:12
 */
@Service
public class LogininforServiceImpl implements LogininforService {
    @Resource
    private LogininforMapper logininforMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Logininfor queryById(Long id) {
        return this.logininforMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param logininfor 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Logininfor> queryByPage(Logininfor logininfor, PageRequest pageRequest) {
        long total = this.logininforMapper.count(logininfor);
        return new PageImpl<>(this.logininforMapper.queryAllByLimit(logininfor, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    @Override
    public Logininfor insert(Logininfor logininfor) {
        this.logininforMapper.insert(logininfor);
        return logininfor;
    }
    
    /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    @Override
    public Logininfor insertSelective(Logininfor logininfor) {
        this.logininforMapper.insertSelective(logininfor);
        return logininfor;
    }
    

    /**
     * 修改数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    @Override
    public Logininfor update(Logininfor logininfor) {
        this.logininforMapper.update(logininfor);
        return this.queryById(logininfor.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.logininforMapper.deleteById(id) > 0;
    }
}
