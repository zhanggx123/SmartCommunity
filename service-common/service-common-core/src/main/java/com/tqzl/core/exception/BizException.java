package com.tqzl.core.exception;

import com.tqzl.core.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ZhangGuoxiang
 * @since 2024-01-24 15:56
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private IErrorCode errorCode;
    private String resultMessage;

    public BizException() {
        super(ResultCodeEnum.FAIL.getResultMessage());
        this.errorCode = ResultCodeEnum.FAIL;
        this.resultMessage = ResultCodeEnum.FAIL.getResultMessage();
    }

    public BizException(IErrorCode errorCode) {
        super(errorCode.getResultMessage());
        this.errorCode = errorCode;
        this.resultMessage = errorCode.getResultMessage();
    }

    public BizException(String resultMessage) {
        super(resultMessage);
        this.errorCode = ResultCodeEnum.FAIL;
        this.resultMessage = resultMessage;
    }

    public BizException(IErrorCode errorCode, String resultMessage) {
        super(resultMessage);
        this.errorCode = errorCode;
        this.resultMessage = resultMessage;
    }
}
