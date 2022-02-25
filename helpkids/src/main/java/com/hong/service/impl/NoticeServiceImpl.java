package com.hong.service.impl;

import com.hong.domain.Notice;
import com.hong.mapper.NoticeMapper;
import com.hong.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 通知公告表(Notice)表服务实现类
 *
 * @author hong
 * @since 2022-02-08 23:59:59
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer id) {
        return this.noticeMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Notice> queryByPage(Notice notice, PageRequest pageRequest) {
        long total = this.noticeMapper.count(notice);
        return new PageImpl<>(this.noticeMapper.queryAllByLimit(notice, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeMapper.insert(notice);
        return notice;
    }
    
    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insertSelective(Notice notice) {
        this.noticeMapper.insertSelective(notice);
        return notice;
    }
    

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeMapper.update(notice);
        return this.queryById(notice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.noticeMapper.deleteById(id) > 0;
    }
}
