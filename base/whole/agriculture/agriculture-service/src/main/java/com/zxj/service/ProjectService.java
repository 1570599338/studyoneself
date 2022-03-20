package com.zxj.service;

import com.zxj.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: agriculture
 * @description: 申请项目的服务
 * @author: zxj
 * @create: 2022-03-20 10:53
 **/
@Service("applyProject")
public class ProjectService {

    @Autowired
    private IProjectService projectService;


    public List<Project> getProject() {
        Project project = new Project();
        project.setAuditStatus(1);
        List<Project> list = projectService.selectProjectList(project);
        return list;
    }

}
