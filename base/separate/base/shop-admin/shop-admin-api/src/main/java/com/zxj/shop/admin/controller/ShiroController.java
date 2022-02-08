package com.zxj.shop.admin.controller;

import com.zxj.shop.admin.entity.User;
import com.zxj.shop.admin.service.ShiroService;
import com.zxj.shop.admin.shiro.RedisManager;
import com.zxj.shop.admin.entity.dto.LoginDTO;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import java.util.Map;


@Api(tags = "登录管理")
@RestController
public class ShiroController {

    @Autowired
    private ShiroService shiroService;
    @Autowired
    private RedisManager redisManager;


    @ApiOperation(value = "登录")
    @PostMapping("/sys/login")
    public ResultVO login(@RequestBody @Validated LoginDTO loginDTO) {
        String redisCode = redisManager.get(loginDTO.getCodekey());
        // 判断验证码
        if (!redisCode.equals(loginDTO.getVeirycode().trim().toLowerCase())) {
            return ResultVO.systemError("验证码输入错误");
        }
        User user = shiroService.findByUserMobile(loginDTO.getMobile());
        if(user == null) {
            return ResultVO.systemError("用户不存在！！！");
        }
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            return ResultVO.systemError("账号或密码有误");
        }
        Map<String,Object> token = shiroService.createToken(user.getId());
        return ResultVO.success(token,"登录成功");
    }

    @ApiOperation(value = "退出")
    @PostMapping("/sys/logout")
    public ResultVO logout(@RequestHeader("token")String token) {
        Subject subject = SecurityUtils.getSubject();
        Object obj = subject.getPrincipal();
      //  User user = (User)subject.getPrincipal();

        User user = new User();
        BeanUtils.copyProperties(subject.getPrincipal(),user);
        int i = shiroService.logout(token,user.getId());
        return ResultVO.success(i);
    }

    @ApiOperation(value = "注册")
    @PostMapping("/sys/register")
    public ResultVO register(User user) {
        return ResultVO.success(shiroService.createUser(user));
    }

    @ApiOperation(value = "根据token获取用户信息")
    @PostMapping("/sys/getToken")
    public ResultVO getToken(@RequestHeader("token") String token) {
        return ResultVO.success(shiroService.getToken(token));
    }

}


