package com.hong.config.shiro;

import com.hong.common.shiro.ShiroUtils;
import com.hong.domain.User;
import com.hong.mapper.ShiroUserMapper;
import com.hong.service.MenuService;
import com.hong.service.RoleService;
import com.hong.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: springs
 * @description: 自定义Ream
 * @author: hong
 * @create: 2022-01-30 16:02
 **/
public class UserRealm extends AuthorizingRealm {

    @Resource
    private ShiroUserMapper shiroUserMapper;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.printf("执行授权逻辑");
//        // 给资源进行授权
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        // 添加资源的授权字符串
//        // info.addStringPermission("user:add");
//        Subject subject = SecurityUtils.getSubject();
//        ShiroUser user = (ShiroUser) subject.getPrincipal();
//        ShiroUser user11 = shiroUserMapper.queryById(user.getId());
//        info.addStringPermission(user11.getAuthor());

        User user = ShiroUtils.getSysUser();
        // 角色列表
        Set<String> roles = new HashSet<String>();
        // 功能列表
        Set<String> menus = new HashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 管理员拥有所有权限
        // if ("admin".equalsIgnoreCase(user.getLoginName())) {
        boolean adminFlage = Boolean.FALSE;
        if(user.getRoleIds()!=null && user.getRoleIds().length>0){
        Long[] roleIds = user.getRoleIds();
            for (long roleid : roleIds) {
                if (roleid == 1) {
                    adminFlage = Boolean.TRUE;
                    break;
                }
            }
        }

        if (user.isAdmin() || adminFlage) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            roles = roleService.selectRoleKeys(user.getId());
            menus = menuService.selectPermsByUserId(user.getId());
            // 角色加入AuthorizationInfo认证对象
            info.setRoles(roles);
            // 权限加入AuthorizationInfo认证对象
            info.setStringPermissions(menus);
        }

        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.printf("执行认证逻辑");
//        // 假设数据库的用户数据和密码
//        //  String name ="hong";
//        // String password = "123456";
//
//        // 编写shiro判断的逻辑，判断用户名和密码
//        // 1、判断用户名
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        ShiroUser user = new ShiroUser();
//        user.setUserName(token.getUsername());
//        List<ShiroUser> list = shiroUserMapper.queryAllByShiroUser(user);
//
//        if (list == null && list.size() <= 0) {
//            return null;//shiro底层会抛出UnknowAccountException
//        }
//
//        //判断密码 第二位才是密码
//        return new SimpleAuthenticationInfo(list.get(0), list.get(0).getUserPassword(), "");

        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }
        User user = userService.login(username, password);
       /* User user = null;
        try {
            user = userService.login(username, password);
        } catch (CaptchaException e) {
            throw new AuthenticationException(e.getMessage(), e);
        } catch (UserNotExistsException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        } catch (UserPasswordNotMatchException e) {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        } catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        } catch (UserBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (RoleBlockedException e) {
            throw new LockedAccountException(e.getMessage(), e);
        } catch (Exception e) {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }


    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
