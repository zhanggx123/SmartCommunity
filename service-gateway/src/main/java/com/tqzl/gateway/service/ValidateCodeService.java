package com.tqzl.gateway.service;



import com.tqzl.core.exception.BizException;
import com.tqzl.core.model.domain.AjaxResult;

import java.io.IOException;

/**
 * 验证码处理
 * 
 * @author thinglinks
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCapcha() throws IOException, BizException;

    /**
     * 校验验证码
     */
    public void checkCapcha(String key, String value) throws BizException;
}
