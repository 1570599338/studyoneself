package com.zxj.domain;

import com.zxj.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 捐款对象 t_donate
 *
 * @author zxj
 * @date 2022-03-20
 */
public class Donate extends BaseEntity {
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
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String tel;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 地址
     */
    private String adress;

    /**
     * 留言
     */
    private String note;

    /**
     * 捐款形式 0线上捐款 1线下捐款
     */
    @Excel(name = "捐款形式 0线上捐款 1线下捐款")
    private Integer type;

    /**
     * 付款方式 0支付宝 1是微信
     */
    @Excel(name = "付款方式 0支付宝 1是微信")
    private Integer payType;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private String payAmount;

    /**
     * 订单号
     */
    @Excel(name = "订单号")
    private String orderNo;

    /**
     * 交易号
     */
    @Excel(name = "交易号")
    private String tradeNo;

    /**
     * 审核人员id
     */
    private Integer projectId;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 审核状态 0：待审核  1：审核通过  2：审核失败  3: 实现愿望
     */
    private Integer auditStatus;

    /**
     * 审核人员id
     */
    private Integer auditId;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("tel", getTel())
                .append("email", getEmail())
                .append("adress", getAdress())
                .append("note", getNote())
                .append("type", getType())
                .append("payType", getPayType())
                .append("payAmount", getPayAmount())
                .append("orderNo", getOrderNo())
                .append("tradeNo", getTradeNo())
                .append("projectId", getProjectId())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("userId", getUserId())
                .append("auditStatus", getAuditStatus())
                .append("auditId", getAuditId())
                .toString();
    }
}
