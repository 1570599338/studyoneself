package com.zxj.service.impl;

import java.util.List;

import com.zxj.common.shiro.ShiroUtils;
import com.zxj.common.text.Convert;
import com.zxj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxj.mapper.ProjectMapper;
import com.zxj.domain.Project;
import com.zxj.service.IProjectService;

import javax.annotation.Resource;


/**
 * 扶贫项目Service业务层处理
 * 
 * @author zxj
 * @date 2022-03-19
 */
@Service
public class ProjectServiceImpl implements IProjectService 
{
    @Resource
    private ProjectMapper projectMapper;

    /**
     * 查询扶贫项目
     * 
     * @param id 扶贫项目ID
     * @return 扶贫项目
     */
    @Override
    public Project selectProjectById(Integer id)
    {
        return projectMapper.selectProjectById(id);
    }

    /**
     * 查询扶贫项目列表
     * 
     * @param project 扶贫项目
     * @return 扶贫项目
     */
    @Override
    public List<Project> selectProjectList(Project project)
    {
        return projectMapper.selectProjectList(project);
    }


    /**
     * 查询扶贫项目列表
     *
     * @param project 扶贫项目
     * @return 扶贫项目
     */
    @Override
    public List<Project> selectProjectHomeList(Project project)
    {
        return projectMapper.selectProjectHomeList(project);
    }

    /**
     * 新增扶贫项目
     * 
     * @param project 扶贫项目
     * @return 结果
     */
    @Override
    public int insertProject(Project project)
    {
        project.setCreateTime(DateUtils.getNowDate());
        return projectMapper.insertProject(project);
    }

    /**
     * 修改扶贫项目
     * 
     * @param project 扶贫项目
     * @return 结果
     */
    @Override
    public int updateProject(Project project)
    {
        project.setUpdateTime(DateUtils.getNowDate());
        project.setUpdateBy(ShiroUtils.getLoginName());


        return projectMapper.updateProject(project);
    }

    /**
     * 删除扶贫项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectByIds(String ids)
    {
        return projectMapper.deleteProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除扶贫项目信息
     * 
     * @param id 扶贫项目ID
     * @return 结果
     */
    @Override
    public int deleteProjectById(Integer id)
    {
        return projectMapper.deleteProjectById(id);
    }
}
