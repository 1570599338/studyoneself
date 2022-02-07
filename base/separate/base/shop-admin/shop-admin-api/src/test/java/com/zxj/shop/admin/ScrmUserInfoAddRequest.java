package com.zxj.shop.admin;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * scrm 用户新增
 */
public class ScrmUserInfoAddRequest {
    @NotBlank(message = "用户姓名不能为空")
    private String userName;      //用户姓名
    @NotNull(message = "用户性别不能为空")
    private Integer userSex;      //用户性别 0未知 1男 2女
    @NotBlank(message = "用户手机号不能为空")
    private String userMobile;    //用户手机号
    private Integer userSource = 0;
    @NotNull(message = "用户头像不能为null")
    private String userAvatar;    //用户头像
    //@Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String userBirthday;  //用户生日
    private String firstRaisesPet;//初次养宠时间
    @NotNull(message = "城市不能为null")
    private String city;          //城市
    @NotNull(message = "国家不能为null")
    private String country;       //国家
    @NotNull(message = "城市不能为null")
    private String province;      //省份
    @NotNull(message = "省份不能为null")
    private String area;          //区域
    @NotBlank(message = "第三方用户ID不能为空")
    private String thirdUserId;   //第三方用户ID
    @NotNull(message = "来源不能为空")
    private Integer source;       //来源（0：子龙、2：瑞鹏 3：小程序）

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getFirstRaisesPet() {
        return firstRaisesPet;
    }

    public void setFirstRaisesPet(String firstRaisesPet) {
        this.firstRaisesPet = firstRaisesPet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(String thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getUserSource() {
        return userSource;
    }

    public void setUserSource(Integer userSource) {
        this.userSource = userSource;
    }
}
