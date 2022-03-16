package com.zxj.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.zxj.shiro.UserRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @program: springs
 * @description: ShiroConfig
 * @author: lquan
 * @create: 2022-01-30 16:06
 **/
@Configuration
public class ShrioConfig {



    /**
     * 创建shiroFilterFactoryBean
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager){
/*       ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(manager);

        // 设置安全管理器
        *//**
         * shiro 内置过滤器，可以实现权限相关的拦截器
         *          常用的过滤器：
         *              anon:无需认证（登录）可以访问
         *              authc：必须认证可以访问
         *              user:如果使用rememberMe的功能可以直接访问
         *              perms:改资源必须得到资源权限才可以访问
         *              role：该资源必须得到角色权限才可以 访问
         *//*
        Map<String,String> filtMap = new LinkedHashMap();
        //  filtMap.put("/add","authc");
        filtMap.put("/login","anon");// 无需认证可访问
        filtMap.put("/toLogin","anon");// 无需认证可访问


        // 授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        filtMap.put("/add","perms[user:add]");
        filtMap.put("/update","perms[user:update]");

        // 修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置未授权的提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");




        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtMap);
        return shiroFilterFactoryBean;*/



        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(manager);
        // 身份认证失败，则跳转到登录页面的配置
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 权限认证失败，则跳转到指定页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/favicon.ico**", "anon");
        // 前端请求
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/demo/**", "anon");
        filterChainDefinitionMap.put("/alipay/**", "anon");
        filterChainDefinitionMap.put("/reception/**", "anon");
        filterChainDefinitionMap.put("/home/**", "anon");

        filterChainDefinitionMap.put("/ruoyi.png**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/headImage/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/ruoyi/**", "anon");
        filterChainDefinitionMap.put("/captcha/captchaImage**", "anon");
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/system/user/check**", "anon");
        filterChainDefinitionMap.put("/weixinpay/pay", "anon");
        // 退出 logout地址，shiro去清除session
        filterChainDefinitionMap.put("/logout", "logout");
        // 不需要拦截的访问
        filterChainDefinitionMap.put("/login", "anon");
        // 系统权限列表
        // filterChainDefinitionMap.putAll(SpringUtils.getBean(IMenuService.class).selectPermsAll());

//        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
//        filters.put("onlineSession", onlineSessionFilter());
//        filters.put("syncOnlineSession", syncOnlineSessionFilter());
//        filters.put("captchaValidate", captchaValidateFilter());
//        filters.put("kickout", kickoutSessionFilter());
//        // 注销成功，则跳转到指定页面
//        filters.put("logout", logoutFilter());
//        shiroFilterFactoryBean.setFilters(filters);
//
//        // 所有请求需要认证
//        filterChainDefinitionMap.put("/**", "user,kickout,onlineSession,syncOnlineSession");
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }



    @Bean(name = "sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sManager = new DefaultWebSessionManager();
        sManager.setGlobalSessionTimeout(60*60*1000);//30 * 60 *1000 1800000L 30分钟
        // 去掉shiro登录时url里的JSESSIONID
        sManager.setSessionIdUrlRewritingEnabled(false);
        return sManager;

    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm, @Qualifier("sessionManager") SessionManager sessionManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }


}
