package com.tqzl.auth.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/19 15:33]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@ApiModel(value = "用户登录表单")
@Data
public class LoginBody {

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名", required = true)
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", required = true)
    private String captcha;

}
