package com.hong.domain;

import lombok.ToString;

import java.io.Serializable;

/**
 * 用户与岗位关联表(UserPost)实体类
 *
 * @author hong
 * @since 2022-02-09 00:03:17
 */
@ToString
public class UserPost implements Serializable {
    private static final long serialVersionUID = -19377797139020798L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 岗位ID
     */
    private Long postId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

}

