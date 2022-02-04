/**
 * date:2020/12/15
 * author: jiazx
 * description: 前后端分离 token存储
 */
 var dev = "http://127.0.0.1:8001"; //改成后台地址


var baseimg = "http://images.zxjshop.cn";

//登录接口
var loginurl = dev+"/sys/login";
//初始化菜单接口
var initIndex = dev+"/api/init";
//初始化用户
var initUser = dev+"/api/admin/users/user/list";
//初始化菜单列表
var menuList = dev+"/api/admin/setting/menu/list";
//新用户注册接口
var register = dev+"/sys/register";
//推出登录
var logout = dev + "/sys/logout";
//登录日志接口
var loginLog = dev + "/api/admin/setting/logLogin/list";
//初始化角色
var initRole = dev + "/api/admin/setting/rolePermission/list";


//设置全局ajax前置拦截  每一次ajax都把token带过去确保登陆成功凭证
var token = localStorage.getItem("token");
$.ajaxSetup({
	headers: {
		'TOKEN': token ,//每次ajax请求时把token带过去
		//'Set-Cookie', HttpOnly;Secure;SameSite=None
	}
});
//设置后台服务地址
localStorage.setItem("server", dev);