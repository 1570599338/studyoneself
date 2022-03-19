package com.zxj.service;

import com.zxj.domain.Project;
import java.util.List;

/**
 * 扶贫项目Service接口
 * 
 * @author zxj
 * @date 2022-03-19
 */
public interface IProjectService 
{
    /**
     * 查询扶贫项目
     * 
     * @param id 扶贫项目ID
     * @return 扶贫项目
     */
    public Project selectProjectById(Integer id);

    /**
     * 查询扶贫项目列表
     * 
     * @param project 扶贫项目
     * @return 扶贫项目集合
     */
    public List<Project> selectProjectList(Project project);

    /**
     * 新增扶贫项目
     * 
     * @param project 扶贫项目
     * @return 结果
     */
    public int insertProject(Project project);

    /**
     * 修改扶贫项目
     * 
     * @param project 扶贫项目
     * @return 结果
     */
    public int updateProject(Project project);

    /**
     * 批量删除扶贫项目
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectByIds(String ids);

    /**
     * 删除扶贫项目信息
     * 
     * @param id 扶贫项目ID
     * @return 结果
     */
    public int deleteProjectById(Integer id);
}
