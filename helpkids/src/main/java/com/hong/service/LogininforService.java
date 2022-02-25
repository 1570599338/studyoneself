package com.hong.service;

import com.hong.domain.Logininfor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 系统访问记录(Logininfor)表服务接口
 *
 * @author hong
 * @since 2022-02-08 23:59:12
 */
public interface LogininforService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Logininfor queryById(Long id);

    /**
     * 分页查询
     *
     * @param logininfor 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Logininfor> queryByPage(Logininfor logininfor, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    Logininfor insert(Logininfor logininfor);
    
        /**
     * 新增数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    Logininfor insertSelective(Logininfor logininfor);

    /**
     * 修改数据
     *
     * @param logininfor 实例对象
     * @return 实例对象
     */
    Logininfor update(Logininfor logininfor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
