package com.tqzl.system.controller;

import cn.hutool.core.util.ObjUtil;
import com.tqzl.api.domain.UserVO;
import com.tqzl.api.model.LoginUser;
import com.tqzl.core.model.CommonResult;
import com.tqzl.system.service.ISysUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/21 15:04]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Api("用户信息")
@RestController
@RequestMapping("/user")
public class SysUserController {

    private final ISysUserService userService;

    public SysUserController(ISysUserService userService) {
        this.userService = userService;
    }

    /**
     * 获取当前用户信息
     */
    @GetMapping("/info/{username}")
    public CommonResult<LoginUser> info(@PathVariable("username") String username)
    {
        UserVO userVO = userService.queryUserByUserName(username);
        if (ObjUtil.isNull(userVO)){
            return CommonResult.error("用户名或密码错误");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserVO(userVO);
        return CommonResult.success(loginUser);
    }

}
