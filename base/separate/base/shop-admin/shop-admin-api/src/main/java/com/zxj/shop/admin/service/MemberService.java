package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.Member;

public interface MemberService {

    IPage<Member> page(Page<Member> objectPage);

    Member getMemberById(String userId);
}
