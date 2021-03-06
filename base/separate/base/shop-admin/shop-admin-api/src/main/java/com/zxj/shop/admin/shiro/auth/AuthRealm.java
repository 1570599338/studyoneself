package com.zxj.shop.admin.shiro.auth;

import com.zxj.shop.admin.entity.Permission;
import com.zxj.shop.admin.entity.Role;
import com.zxj.shop.admin.entity.SysToken;
import com.zxj.shop.admin.entity.User;
import com.zxj.shop.admin.service.PermissionService;
import com.zxj.shop.admin.service.RoleService;
import com.zxj.shop.admin.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class AuthRealm extends AuthorizingRealm {

    //居然导致了事务不生效emmmm
    //https://blog.csdn.net/QQ1802575698/article/details/94462370?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.channel_param
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
      //  User user = new User();

      //  BeanUtils.copyProperties(principals.getPrimaryPrincipal(),user);

       // RoleService roleService = applicationContext.getBean(RoleService.class);
       // PermissionService permissionService = applicationContext.getBean(PermissionService.class);;
        User user = (User)principals.getPrimaryPrincipal();
        List<Role> roles = roleService.getUserRoles(user.getId().toString());
        List<Integer> rolesIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<String>  rolesName = roles.stream().map(Role::getName).collect(Collectors.toList());

        List<String> permissions = new ArrayList<>();

        rolesIds.stream().forEach((e) ->{
            List<Permission> permission = permissionService.getUserPermission(e.toString());
            permissions.addAll(permission.stream().map(Permission::getPermCode).collect(Collectors.toList()));
        });
        // 为当前用户设置角色和权限

        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

        simpleAuthorInfo.addRoles(rolesName);
        simpleAuthorInfo.addStringPermissions(permissions);
        return simpleAuthorInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取token，既前端传入的token
        String accessToken = (String) token.getPrincipal();
        //1. 根据accessToken，查询用户信息
        ShiroService shiroService = applicationContext.getBean(ShiroService.class);
        SysToken sysToken = shiroService.findByToken(accessToken);
        //2. token失效
        if (sysToken == null || sysToken.getExpireTime().before(new Date())) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        User user = shiroService.findByUserId(sysToken.getUserId());
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (user == null) {
            throw new UnknownAccountException("用户不存在!");
        }
        //5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, this.getName());
        return info;
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
