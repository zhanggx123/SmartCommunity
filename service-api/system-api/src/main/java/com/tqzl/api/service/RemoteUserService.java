package com.tqzl.api.service;

import com.tqzl.api.domain.UserVO;
import com.tqzl.api.factory.RemoteUserFallbackFactory;
import com.tqzl.api.model.LoginUser;
import com.tqzl.core.constant.SecurityConstants;
import com.tqzl.core.constant.ServiceNameConstants;
import com.tqzl.core.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/20 9:57]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source 请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    public CommonResult<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
