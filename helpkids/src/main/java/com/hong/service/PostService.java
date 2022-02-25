package com.hong.service;

import com.hong.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 岗位信息表(Post)表服务接口
 *
 * @author hong
 * @since 2022-02-09 00:00:53
 */
public interface PostService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Post queryById(Long id);

    /**
     * 分页查询
     *
     * @param post 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Post> queryByPage(Post post, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    Post insert(Post post);
    
        /**
     * 新增数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    Post insertSelective(Post post);

    /**
     * 修改数据
     *
     * @param post 实例对象
     * @return 实例对象
     */
    Post update(Post post);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 查询所有岗位
     *
     * @return 岗位列表
     */
    public List<Post> selectPostAll();

}
