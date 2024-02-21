package com.tqzl.auth.controller;

import com.tqzl.api.model.LoginUser;
import com.tqzl.auth.form.LoginBody;
import com.tqzl.auth.service.LoginService;
import com.tqzl.auth.service.TokenService;
import com.tqzl.core.model.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/19 15:12]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Api("登录接口")
@RestController
public class AuthController {

    private final TokenService tokenService;
    private final LoginService loginService;

    public AuthController(LoginService loginService, TokenService tokenService) {
        this.loginService = loginService;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginBody param, HttpServletRequest request){
        LoginUser login = loginService.login(param, request);
        return CommonResult.success(tokenService.createToken(login));
    }
}