package com.tqzl.api.factory;

import com.tqzl.api.domain.UserVO;
import com.tqzl.api.model.LoginUser;
import com.tqzl.api.service.RemoteUserService;
import com.tqzl.core.model.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/20 10:11]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService()
        {
            @Override
            public CommonResult<LoginUser> getUserInfo(String username, String source)
            {
                return CommonResult.fail("获取用户失败:" + throwable.getMessage());
            }
        };
    }
}

