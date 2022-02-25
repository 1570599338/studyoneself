package com.hong.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hong.annotation.Excel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 愿望申领单对象 t_apply
 *
 * @author hong
 * @date 2022-02-23
 */
public class Apply {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String tel;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String adress;

    /**
     * 申请理由
     */
    @Excel(name = "申请理由")
    private String reason;

    /**
     * 心愿id
     */
    @Excel(name = "心愿id")
    private Integer wishId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Integer useId;

    /**
     * 审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望
     */
    @Excel(name = "审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望")
    private Integer auditStatus;

    /**
     * 审核人员id
     */
    @Excel(name = "审核人员id")
    private Integer auditId;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;



    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public Integer getWishId() {
        return wishId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
