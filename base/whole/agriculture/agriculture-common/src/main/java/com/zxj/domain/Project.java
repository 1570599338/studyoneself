package com.zxj.domain;

import com.zxj.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 扶贫项目对象 t_project
 *
 * @author zxj
 * @date 2022-03-19
 */
public class Project extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 名称 */
    @Excel(name = "名称")
    private String title;

    /** 图片地址 */
    private String imgurl;

    /** 扶贫项目简介 */
    private String projectShort;

    /** 扶贫项目简介 */
    private String projectInfo;

    /** 扶贫类型 0:代表金钱；1：人力物力 */
    @Excel(name = "扶贫类型 0:代表金钱；1：人力物力")
    private Integer projectType;

    /** 扶贫资金 */
    @Excel(name = "扶贫资金")
    private Integer projectFund;

    /** 发布状态 0:未发布；1：发布 */
    @Excel(name = "发布状态 0:未发布；1：发布")
    private Integer ispublish;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 展示位置0：轮播图，1:其他位置 */
    @Excel(name = "展示位置0：轮播图，1:其他位置")
    private Integer projectPost;

    /** 用户id */
    private Integer userId;

    /** 审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望 */
    private Integer auditStatus;

    /** 审核人员id */
    private Integer auditId;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    public String getImgurl()
    {
        return imgurl;
    }
    public void setProjectShort(String projectShort)
    {
        this.projectShort = projectShort;
    }

    public String getProjectShort()
    {
        return projectShort;
    }
    public void setProjectInfo(String projectInfo)
    {
        this.projectInfo = projectInfo;
    }

    public String getProjectInfo()
    {
        return projectInfo;
    }
    public void setProjectType(Integer projectType)
    {
        this.projectType = projectType;
    }

    public Integer getProjectType()
    {
        return projectType;
    }
    public void setProjectFund(Integer projectFund)
    {
        this.projectFund = projectFund;
    }

    public Integer getProjectFund()
    {
        return projectFund;
    }
    public void setIspublish(Integer ispublish)
    {
        this.ispublish = ispublish;
    }

    public Integer getIspublish()
    {
        return ispublish;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setProjectPost(Integer projectPost)
    {
        this.projectPost = projectPost;
    }

    public Integer getProjectPost()
    {
        return projectPost;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setAuditStatus(Integer auditStatus)
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus()
    {
        return auditStatus;
    }
    public void setAuditId(Integer auditId)
    {
        this.auditId = auditId;
    }

    public Integer getAuditId()
    {
        return auditId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("imgurl", getImgurl())
                .append("projectShort", getProjectShort())
                .append("projectInfo", getProjectInfo())
                .append("projectType", getProjectType())
                .append("projectFund", getProjectFund())
                .append("ispublish", getIspublish())
                .append("delFlag", getDelFlag())
                .append("projectPost", getProjectPost())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("userId", getUserId())
                .append("auditStatus", getAuditStatus())
                .append("auditId", getAuditId())
                .toString();
    }
}
