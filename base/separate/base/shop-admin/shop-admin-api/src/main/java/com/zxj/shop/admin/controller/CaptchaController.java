package com.zxj.shop.admin.controller;

import com.wf.captcha.ArithmeticCaptcha;
import com.zxj.shop.admin.shiro.RedisManager;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "验证码管理")
@Controller
@RequestMapping("/captcha")
@ResponseBody
public class CaptchaController {

	@Autowired
	private RedisManager redisManager;

	@ApiOperation(value = "生成验证码")
	@GetMapping("/code")
	public ResultVO getCode() {
		ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48 , 2);
		captcha.getArithmeticString();

		// 存入redis并设置过期时间10分钟
		String key = UUID.randomUUID().toString();

		Map<String,String> cap = new HashMap<>();
		cap.put("key", key);
		cap.put("code",captcha.toBase64());

		redisManager.set(key , captcha.text() ,60 * 10);

		return ResultVO.success(cap);
	}
}
