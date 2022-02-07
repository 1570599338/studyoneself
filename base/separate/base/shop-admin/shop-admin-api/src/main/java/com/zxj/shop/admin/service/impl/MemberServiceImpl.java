package com.zxj.shop.admin.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.Member;
import com.zxj.shop.admin.mapper.MemberMapper;
import com.zxj.shop.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("master_2")
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberMapper memberMapper;

    @Override
    public IPage<Member> page(Page<Member> objectPage) {
        return memberMapper.selectPage(objectPage,new QueryWrapper<>());
    }

    @Override
    public Member getMemberById(String userId) {
        return memberMapper.selectById(userId);
    }
}
