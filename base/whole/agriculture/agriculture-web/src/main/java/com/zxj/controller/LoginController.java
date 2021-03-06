package com.zxj.controller;


import com.zxj.bean.Resp.AjaxResult;
import com.zxj.common.utils.ServletUtils;
import com.zxj.common.utils.StringUtils;
import com.zxj.domain.User;
import com.zxj.mapper.UserMapper;
import com.zxj.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证
 *
 * @author zxj
 */
@Controller
public class LoginController extends BaseController {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password,String validateCode, Boolean tourist, HttpServletRequest request) {
        if(validateCode==null){
            return AjaxResult.error("请输入验证码！");
        }
        HttpSession session = request.getSession(true);

        if (!session.getAttribute("randCheckCode").toString().equalsIgnoreCase(validateCode)) {
            return AjaxResult.error("验证码错误！");
        }
        User user = userService.login(username,null);


        if(user==null){
            return AjaxResult.error("该用户不存在");
        }

        if(!user.isAdmin()){
            if(user.getAudit()==null){
                user.setAudit(0);
            }
            if(user.getAudit()==0){
                return AjaxResult.error("请联系管理员进行审核后在登陆！");
            }
            if(user.getAudit()==2){
                return AjaxResult.error("审核不通过，无权限登陆！");
            }
        }

        UsernamePasswordToken token  = new UsernamePasswordToken(username, password);


        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (tourist) {
                return AjaxResult.success("登录成功", "tourist");
            }

            return success();
        }catch (UnknownAccountException e) { //UnknownAccountException 未知的账号异常

            return AjaxResult.error("用户名不存在");

        }catch (IncorrectCredentialsException e) { //IncorrectCredentialsException 不正确的凭证异常

            return AjaxResult.error("密码错误");

        }catch (AuthenticationException e) { //AuthenticationException 认证异常

            return AjaxResult.error("未知错误");

        }
    }

    @GetMapping("/unauth")
    public String unauth() {
        return "error/unauth";
    }


    public User getRandSysUser() {
        return userMapper.getRandUser();
    }
}
