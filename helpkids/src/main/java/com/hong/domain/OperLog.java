package com.hong.domain;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志记录(OperLog)实体类
 *
 * @author hong
 * @since 2022-02-09 00:00:24
 */
@ToString
public class OperLog implements Serializable {
    private static final long serialVersionUID = -20265853496260889L;
    /**
     * 日志主键
     */
    private Long id;
    /**
     * 模块标题
     */
    private String title;
    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    private Integer businessType;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 请求方式
     */
    private String requestMethod;
    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer operatorType;
    /**
     * 操作人员
     */
    private String operName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 请求URL
     */
    private String operUrl;
    /**
     * 主机地址
     */
    private String operIp;
    /**
     * 操作地点
     */
    private String operLocation;
    /**
     * 请求参数
     */
    private String operParam;
    /**
     * 返回参数
     */
    private String jsonResult;
    /**
     * 操作状态（0正常 1异常）
     */
    private Integer status;
    /**
     * 错误消息
     */
    private String errorMsg;
    /**
     * 操作时间
     */
    private Date operTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

}

