package com.zxj.bean.req;

import lombok.ToString;

/**
 * @program: agriculture
 * @description: 捐赠类
 * @author: lquan
 * @create: 2022-03-19 22:11
 **/
@ToString
public class Donate {
    // 姓名
    private String name;
    // 联系方式
    private String tel;
    // 邮箱
    private  String email;
    // 地址
    private String adress;
    // 留言
    private String note;
    // 捐款形式 线上捐款还是线下捐款
    private int type;

    // 付款方式 支付宝还是微信
    private int payType;

    // 捐款金额
    private String payAmount ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }
}
