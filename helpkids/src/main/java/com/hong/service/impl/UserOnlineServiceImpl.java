package com.hong.service.impl;

import com.hong.domain.UserOnline;
import com.hong.mapper.UserOnlineMapper;
import com.hong.service.UserOnlineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在线用户记录(UserOnline)表服务实现类
 *
 * @author hong
 * @since 2022-02-09 00:02:54
 */
@Service
public class UserOnlineServiceImpl implements UserOnlineService {
    @Resource
    private UserOnlineMapper userOnlineMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserOnline queryById(Long id) {
        return this.userOnlineMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userOnline 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserOnline> queryByPage(UserOnline userOnline, PageRequest pageRequest) {
        long total = this.userOnlineMapper.count(userOnline);
        return new PageImpl<>(this.userOnlineMapper.queryAllByLimit(userOnline, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    @Override
    public UserOnline insert(UserOnline userOnline) {
        this.userOnlineMapper.insert(userOnline);
        return userOnline;
    }
    
    /**
     * 新增数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    @Override
    public UserOnline insertSelective(UserOnline userOnline) {
        this.userOnlineMapper.insertSelective(userOnline);
        return userOnline;
    }
    

    /**
     * 修改数据
     *
     * @param userOnline 实例对象
     * @return 实例对象
     */
    @Override
    public UserOnline update(UserOnline userOnline) {
        this.userOnlineMapper.update(userOnline);
        return this.queryById(userOnline.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userOnlineMapper.deleteById(id) > 0;
    }
}
