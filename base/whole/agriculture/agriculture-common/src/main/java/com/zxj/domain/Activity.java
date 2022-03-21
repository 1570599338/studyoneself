package com.zxj.domain;

import com.zxj.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 惠农之路对象 t_activity
 * 
 * @author zxj
 * @date 2022-03-21
 */
public class Activity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgurl;

    /** 简介 */
    @Excel(name = "简介")
    private String activityShort;

    /** 主要内容 */
    private String activityInfo;

    /** 审核状态 0：带发布  1：发布 */
    @Excel(name = "审核状态")
    private Integer isPublish;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

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
    public void setActivityShort(String activityShort) 
    {
        this.activityShort = activityShort;
    }

    public String getActivityShort() 
    {
        return activityShort;
    }
    public void setActivityInfo(String activityInfo) 
    {
        this.activityInfo = activityInfo;
    }

    public String getActivityInfo() 
    {
        return activityInfo;
    }
    public void setIsPublish(Integer isPublish) 
    {
        this.isPublish = isPublish;
    }

    public Integer getIsPublish() 
    {
        return isPublish;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("imgurl", getImgurl())
            .append("activityShort", getActivityShort())
            .append("activityInfo", getActivityInfo())
            .append("isPublish", getIsPublish())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
