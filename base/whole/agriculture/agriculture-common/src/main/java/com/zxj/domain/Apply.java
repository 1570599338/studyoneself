package com.zxj.domain;

import com.zxj.annotation.Excel;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 申请对象 t_apply
 * 
 * @author zxj
 * @date 2022-03-20
 */
@ToString
public class Apply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String tel;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String nationalId;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String adress;

    /** 图片地址 */
    private String imgurl;

    /** 受灾简述 */
    private String applyShort;

    /** 受灾情况简介 */
    private String applyInfo;

    /** 受灾申请金额 */
    private String applyAmount;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 用户id */
    private Integer userId;
    /** 申请项目id */
    private Integer projectId;

    /** 受灾申请金额 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望 */
    @Excel(name = "审核状态")
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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setNationalId(String nationalId) 
    {
        this.nationalId = nationalId;
    }

    public String getNationalId() 
    {
        return nationalId;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public String getAdress() 
    {
        return adress;
    }
    public void setImgurl(String imgurl) 
    {
        this.imgurl = imgurl;
    }

    public String getImgurl() 
    {
        return imgurl;
    }
    public void setApplyShort(String applyShort) 
    {
        this.applyShort = applyShort;
    }

    public String getApplyShort() 
    {
        return applyShort;
    }
    public void setApplyInfo(String applyInfo) 
    {
        this.applyInfo = applyInfo;
    }

    public String getApplyInfo() 
    {
        return applyInfo;
    }
    public void setApplyAmount(String applyAmount) 
    {
        this.applyAmount = applyAmount;
    }

    public String getApplyAmount() 
    {
        return applyAmount;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
