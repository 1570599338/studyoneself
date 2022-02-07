package com.zxj.shop.admin.exception;

import com.zxj.shop.admin.entity.vo.ResultVO;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;


@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultVO handleServiceException(BusinessException e) {
        return ResultVO.systemError(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultVO handle(BindException e) {
        StringBuilder errorInfo = new StringBuilder();
        String msg = e.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("，"));
        return ResultVO.systemError(msg);
    }

    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public ResultVO handleShiroException(Exception ex) {
        return ResultVO.systemError("您无权限操作");
    }
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public ResultVO AuthorizationException(Exception ex) {
        return ResultVO.systemError("权限认证失败");
    }
}
