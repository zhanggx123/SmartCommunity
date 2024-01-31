package com.tqzl.core.enums;

import com.tqzl.core.exception.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhangGuoxiang
 * @since 2024-01-24 13:46
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum implements IErrorCode {
    /**
     * 返回码
     */
    SUCCESS("SUCCESS", "处理成功"),
    FAIL("FAIL", "处理失败"),
    ERROR("ERROR", "处理异常"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知异常"),
    UNAUTHORIZED("UNAUTHORIZED", "认证失败"),
    NOT_FOUND("NOT_FOUND", "数据不存在"),
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION", "未知异常"),
    PARAM_NULL("PARAM_NULL", "参数不能为空"),
    PARAM_ERROR("PARAM_ERROR", "参数错误"),
    XXL_JOB_EXCEPTION("XXL_JOB_EXCEPTION", "xxlJob接口异常"),
    BIZ_EXCEPTION("BIZ_EXCEPTION", "业务异常");

    private final String resultCode;
    private final String resultMessage;
}
