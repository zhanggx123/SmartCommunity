package com.tqzl.system.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/28 10:20]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Data
@ApiModel("用户传输对象")
public class UserDTO {

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("头像地址")
    private String avatar;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("性别")
    private int sex;
    @ApiModelProperty("电话")
    private String tel;

}
