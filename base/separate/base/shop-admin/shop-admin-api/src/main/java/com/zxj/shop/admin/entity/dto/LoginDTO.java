package com.zxj.shop.admin.entity.dto;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 登录传输类
 */
@Data
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;

    private String codekey;
    @NotBlank(message = "验证码不能为空")
    private String veirycode;

}
