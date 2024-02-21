package com.tqzl.auth.service;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.tqzl.api.domain.UserVO;
import com.tqzl.api.model.LoginUser;
import com.tqzl.api.service.RemoteUserService;
import com.tqzl.auth.form.LoginBody;
import com.tqzl.core.constant.SecurityConstants;
import com.tqzl.core.exception.BizException;
import com.tqzl.core.model.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/19 15:45]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Component
public class LoginService {


    @Autowired
    private RemoteUserService remoteUserService;


    public LoginUser login(LoginBody loginBody, HttpServletRequest request){
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StrUtil.isEmpty(loginBody.getCaptcha()) || loginBody.getCaptcha().equals(captcha)){
            throw new BizException("验证码错误");
        }

        CommonResult<LoginUser> userInfo = remoteUserService.getUserInfo(loginBody.getUserName(), SecurityConstants.INNER);
        if(ObjUtil.isNull(userInfo)){
            throw new BizException("用户不存在");
        }

        return userInfo.getResultObject();
    }
}
