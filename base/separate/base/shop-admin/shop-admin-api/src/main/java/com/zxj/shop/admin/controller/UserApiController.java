package com.zxj.shop.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxj.shop.admin.entity.Member;
import com.zxj.shop.admin.entity.MsgRecord;
import com.zxj.shop.admin.entity.User;
import com.zxj.shop.admin.service.MemberService;
import com.zxj.shop.admin.service.MsgService;
import com.zxj.shop.admin.service.ShiroService;
import com.zxj.shop.admin.entity.vo.PageBean;
import com.zxj.shop.admin.entity.vo.PageVO;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags = "用户管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class UserApiController {

    @Autowired
    private ShiroService shiroService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MsgService msgService;


    @ApiOperation(value = "用户信息列表")
    @GetMapping("/users/user/list")
    public PageVO<User> list(User user, PageBean pageBean) {
        IPage<User> userPage = shiroService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()), user);
        return PageVO.pageVO(userPage.getRecords(), userPage.getTotal());
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/users/user/confirm/add")
    public ResultVO confirmAdd(User sysAccount) {
        return ResultVO.success(shiroService.createUser(sysAccount));
    }


    @PostMapping("/users/user/confirm/edit")
    @ApiOperation(value = "用户编辑")
    public ResultVO confirmEdit(User sysAccount) {
        return ResultVO.success(shiroService.updateUser(sysAccount));
    }

    @PostMapping("/users/user/setting")
    @ApiOperation(value = "setting信息设置")
    public ResultVO setting(User sysAccount) {
        return ResultVO.success(shiroService.updateUserById(sysAccount));
    }

    @PostMapping("/users/user/view")
    @ApiOperation(value = "view")
    public ResultVO<Map<String,Object>> view(@RequestParam(required = false) String token,
                                             @RequestParam(required = false) String userId) {
        return ResultVO.success(shiroService.view(token,userId));
    }

    @ApiOperation(value = "用户锁定")
    @PostMapping("/users/user/confirm/locked")
    public ResultVO locked(User sysAccount) {
        return ResultVO.success(shiroService.locked(sysAccount));
    }


    @ApiOperation(value = "会员列表")
    @GetMapping("/member/list")
    public PageVO<Member> list(PageBean pageBean) {
        IPage<Member> logLoginPage = memberService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()));
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }

    @ApiOperation(value = "短信列表")
    @GetMapping("/member/message")
    public PageVO<MsgRecord> message(MsgRecord msgRecord, PageBean pageBean) {
        IPage<MsgRecord> logLoginPage = msgService.page(new Page<>(pageBean.getPage(), pageBean.getLimit()),msgRecord);
        return PageVO.pageVO(logLoginPage.getRecords(), logLoginPage.getTotal());
    }

    @PostMapping("/member/view")
    @ApiOperation(value = "会员详情")
    public ResultVO<Member> view(@RequestParam(required = false) String userId) {
        return ResultVO.success(memberService.getMemberById(userId));
    }
}
