package com.tqzl.core.model;

import com.tqzl.core.enums.ResultCodeEnum;
import com.tqzl.core.exception.IErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ZhangGuoxiang
 * @since 2024-01-24 15:56
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("是否成功")
    private Boolean isSuccess;
    @ApiModelProperty("状态码")
    private String resultCode;
    @ApiModelProperty("提示信息")
    private String resultMessage;
    @ApiModelProperty("数据")
    private T resultObject;

    public static <T> CommonResult<T> success() {
        return of(ResultCodeEnum.SUCCESS);
    }

    public static <T> CommonResult<T> success(T data) {
        return of(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> CommonResult<T> fail(String msg) {
        return of(ResultCodeEnum.FAIL, msg);
    }

    public static <T> CommonResult<T> error() {
        return of(ResultCodeEnum.ERROR);
    }

    public static <T> CommonResult<T> error(String msg) {
        return of(ResultCodeEnum.ERROR, msg);
    }

    public static <T> CommonResult<T> of(IErrorCode errorCode) {
        return new CommonResult<T>().setIsSuccess(isSuccess(errorCode)).setResultCode(errorCode.getResultCode()).setResultMessage(errorCode.getResultMessage());
    }

    public static <T> CommonResult<T> of(IErrorCode errorCode, String resultMessage) {
        return new CommonResult<T>().setIsSuccess(isSuccess(errorCode)).setResultCode(errorCode.getResultCode()).setResultMessage(resultMessage);
    }

    public static <T> CommonResult<T> of(IErrorCode errorCode, T resultObject) {
        return new CommonResult<T>().setIsSuccess(isSuccess(errorCode)).setResultCode(errorCode.getResultCode()).setResultMessage(errorCode.getResultMessage()).setResultObject(resultObject);
    }

    private static boolean isSuccess(IErrorCode errorCode) {
        return ResultCodeEnum.SUCCESS.getResultCode().equals(errorCode.getResultCode());
    }
}
