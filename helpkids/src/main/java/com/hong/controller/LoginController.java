package com.hong.controller;

import com.hong.bean.Resp.AjaxResult;
import com.hong.domain.User;
import com.hong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hong.bean.Resp.AjaxResult.success;

/**
 * 系统访问记录(Logininfor)表控制层
 *
 * @author hong
 * @since 2022-02-08 23:59:12
 */
@Slf4j
@Controller
public class LoginController {
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean tourist) {
//        UsernamePasswordToken token;
//        if (tourist) {
//            User user = getRandSysUser();
//            token = new UsernamePasswordToken(user.getLoginName(), FnvHash.Constants.PASSWORD);
//        } else {
//            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//                return AjaxResult.error("用户名或者密码不能为空！");
//            }
//            token = new UsernamePasswordToken(username, password);
//        }

        User user = userService.login(username,null);
        if(user==null){
            return AjaxResult.error("该用户不存在");
        }
        if(user.getAudit()==0){
            return AjaxResult.error("请联系管理员进行审核后在登陆！");
        }
        if(user.getAudit()==2){
            return AjaxResult.error("审核不通过，无权限登陆！");
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);


            return AjaxResult.success();
       /** } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return AjaxResult.error(msg);
        }**/
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


}

