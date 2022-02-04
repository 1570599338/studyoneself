package com.zxj.shop.admin.service.impl;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.*;
import com.zxj.shop.admin.service.RoleService;
import com.zxj.shop.admin.utils.CosUtil;
import com.zxj.shop.admin.utils.HttpUtils;
import com.zxj.shop.admin.utils.ObjectUtil;
import com.zxj.shop.admin.exception.BusinessException;
import com.zxj.shop.admin.mapper.LogMapper;
import com.zxj.shop.admin.mapper.TokenMapper;
import com.zxj.shop.admin.mapper.UserMapper;
import com.zxj.shop.admin.service.ShiroService;
import com.zxj.shop.admin.utils.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShiroServiceImpl extends ServiceImpl<UserMapper,User> implements ShiroService
{

    //12小时后失效
    private final static int EXPIRE = 12;

    @Autowired
    UserMapper userMapper;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    LogMapper  logMapper;
    @Autowired
    RoleService roleService;

    private final CosUtil cosUtil;

    static Logger logger = LoggerFactory.getLogger(ShiroServiceImpl.class);

    @Override
    public SysToken findByToken(String accessToken) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("token",accessToken);
        return tokenMapper.selectOne(wrapper);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public User findByUserMobile(String mobile) {
        return userMapper.findByUserMobile(mobile);
    }

    @Override
    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>();
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        //判断是否生成过token
        SysToken sysToken = tokenMapper.findByUserId(userId);

        if(sysToken!=null) {
            updateUserToken(userId, token, now, expireTime);
        }else {
            tokenMapper.insert(ObjectUtil.initObject(new SysToken())
                    .init(v -> v.setUserId(userId))
                    .init(v -> v.setToken(token))
                    .init(v -> v.setUpdateTime(Date.from(now.atZone(ZoneId.systemDefault()).toInstant())))
                    .init(v -> v.setExpireTime(Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant())))
                    .getObject());
        }

        User user = userMapper.selectById(userId);
        user.setLastVisit(new Date());
        user.setLoginCount(user.getLoginCount() + 1);
        userMapper.updateById(user);

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

        String requestHeader = request.getHeader("user-agent");
        UserAgent userAgent = UserAgentUtil.parse(requestHeader);

        String ip = getIpAddress(request);
        Map<String, JSONObject> map = getAddressByIp(ip);

        if(map != null) {
            logMapper.insert(ObjectUtil.initObject(new SysLog())
                    .init(v -> v.setMobile(user.getMobile()))
                    .init(v -> v.setIp(ip))
                    .init(v -> v.setLoginTime(new Date()))
                    .init(v -> v.setProvince(map.get("address").getString("province")))
                    .init(v -> v.setCity(map.get("address").getString("city")))
                    .init(v -> v.setOs(userAgent.getBrowser().getName()))
                    .init(v -> v.setBrowser(userAgent.getBrowser().getName()))
                    .init(v -> v.setPointX(map.get("point").getBigDecimal("x")))
                    .init(v -> v.setPointY(map.get("point").getBigDecimal("y")))
                    .getObject());
        } else {
            logMapper.insert(ObjectUtil.initObject(new SysLog())
                    .init(v -> v.setMobile(user.getMobile()))
                    .init(v -> v.setIp(ip))
                    .init(v -> v.setLoginTime(new Date()))
                    .init(v -> v.setOs(userAgent.getBrowser().getName()))
                    .init(v -> v.setBrowser(userAgent.getBrowser().getName()))
                    .getObject());
        }
        result.put("token", token);
        result.put("expire", expireTime);
        return result;
    }

    private void updateUserToken(Integer userId, String token, LocalDateTime now, LocalDateTime expireTime) {
        tokenMapper.updateById(ObjectUtil.initObject(new SysToken())
                .init(v -> v.setUserId(userId))
                .init(v -> v.setToken(token))
                .init(v -> v.setUpdateTime(Date.from(now.atZone(ZoneId.systemDefault()).toInstant())))
                .init(v -> v.setExpireTime(Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant())))
                .getObject());
    }


    @Override
    public int logout(String token,Integer userId) {
        //生成一个token
        String token_ = TokenGenerator.generateValue();
        //当前时间
        LocalDateTime now = LocalDateTime.now();
        //过期时间
        LocalDateTime expireTime = now.plusHours(EXPIRE);


        updateUserToken(userId, token_, now, expireTime);

        return 1;
    }

    @Override
    public IPage<User> page(Page<User> page, User user) {
        QueryWrapper<User> queryWrapper  = new QueryWrapper<User>();
        if(StringUtils.isNotBlank(user.getSearch())) {
            queryWrapper.and(wrapper-> wrapper.like("name",user.getSearch()).or().like("mobile",user.getSearch()));
        }
        return userMapper.selectPage(page, queryWrapper);
    }


    @Override
    @Transactional
    public int createUser(User user) {
        if(userMapper.findByUserMobile(user.getMobile()) != null) {
            throw new BusinessException("用户已经注册，请去登录");
        }
        userMapper.insert(ObjectUtil.initObject(user)
                .init(v -> v.setBirthday(user.getBirthday()))
                .init(v -> v.setEmail(user.getEmail()))
                .init(v -> v.setMobile(user.getMobile()))
                .init(v -> v.setPassword(user.getPassword()))
                .init(v -> v.setName(user.getMobile()))
                .init(v -> v.setCreateDate(new Date()))
                .init(v -> v.setLastVisit(new Date()))
                .init(v -> v.setLoginCount(0))
                .init(v -> v.setState("0"))
                .getObject());

        if(user.getRoleIds() == null || user.getRoleIds().size() == 0) {
            //赋权限
            userMapper.createUserRole(ObjectUtil.initObject(new UserRole())
                    .init(v -> v.setRoleId(1)) //默认给一个admin
                    .init(v -> v.setUserId(user.getId()))
                    .getObject());
        } else {
            user.getRoleIds().forEach((e) -> {
                userMapper.createUserRole(ObjectUtil.initObject(new UserRole())
                        .init(v -> v.setRoleId(Integer.parseInt(e)))
                        .init(v -> v.setUserId(user.getId()))
                        .getObject());
            });
        }
        return 1;
    }


    @Override
    @Transactional
    public int updateUser(User user) {
        updateUserById(user);

        userMapper.deleteUserRole(ObjectUtil.initObject(new UserRole())
                                        .init(v -> v.setUserId(user.getId())).getObject());

        user.getRoleIds().forEach((e) -> {
            userMapper.createUserRole(ObjectUtil.initObject(new UserRole())
                    .init(v -> v.setRoleId(Integer.parseInt(e)))
                    .init(v -> v.setUserId(user.getId()))
                    .getObject());
        });
        return 1;
    }

    @Override
    public User getToken(String token) {
        SysToken sysToken = findByToken(token);
        User user = findByUserId(sysToken.getUserId());
        return user;
    }


    @Override
    public Map<String, Object> view(String token, String userId) {
        Map<String,Object> maps = new HashMap<>();

        User user = null;
        //从个人中心过来，否则是从用户列表进来的
        if(StringUtils.isNotEmpty(token)) {
            user = getToken(token);
        }
        if(StringUtils.isNotEmpty(userId)) {
            user = findByUserId(Integer.parseInt(userId));
        }
        Map<Integer,String> userRoles = roleService.getUserRoles(user.getId().toString()).
                stream().collect(Collectors.toMap(Role::getId,Role::getName));
        List<Role> roles = roleService.getRoles();
        for (Role r: roles) {
            String role =  userRoles.get(r.getId());
            if(StringUtils.isNotBlank(role)) {
                r.setChecked(true);
            }
        }
        maps.put("role", roles);
        maps.put("user", user);
        return maps;
    }

    @Override
    public int updateUserById(User user) {
        User uers = findByUserId(user.getId());
        if(uers == null) {
            throw new BusinessException("用户不存在");
        }
        userMapper.updateById(ObjectUtil.initObject(new User())
                .init(v -> v.setBirthday(user.getBirthday()))
                .init(v -> v.setEmail(user.getEmail()))
                .init(v -> v.setMobile(user.getMobile()))
                .init(v -> v.setPassword(user.getPassword()))
                .init(v -> v.setName(user.getMobile()))
                .init(v -> v.setGender(user.getGender()))
                .init(v -> v.setIcon(user.getIcon()))
                .init(v -> v.setNote(user.getNote()))
                .init(v -> v.setCreateDate(new Date()))
                .init(v -> v.setLastVisit(new Date()))
                .init(v -> v.setId(user.getId()))
                .init(v -> v.setVersion(uers.getVersion()))
                .getObject());
        return 1;
    }

    @Override
    public int locked(User sysAccount) {
        userMapper.update(sysAccount , new UpdateWrapper<User>().lambda().eq(User::getId, sysAccount.getId()));
        return 1;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        return ip;
    }

    /**
     * 根据IP 查询城市信息
     */
    public static Map<String,JSONObject> getAddressByIp(String ip) {
        JSONObject object = HttpUtils.requestGet("http://api.map.baidu.com/location/ip?ak=cTYtHPV1spdnWgFSeKfXqjTh&coor=bd09ll&ip=" + ip).getJSONObject("content");
        if (object != null) {
            Map<String,JSONObject> map = new HashMap<>();
            map.put("point"  , object.getJSONObject("point"));
            map.put("address", object.getJSONObject("address_detail"));
            return map;
        }
        return null;
    }

}
