package com.hong.domain;

import lombok.ToString;

import java.io.Serializable;

/**
 * (ShiroUser)实体类
 *
 * @author hong
 * @since 2022-02-02 01:41:53
 */
@ToString
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = -72480549322027669L;
    /**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 授权
     */
    private String author;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}

