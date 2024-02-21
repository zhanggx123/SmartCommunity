package com.tqzl.api.domain;

import com.tqzl.core.model.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Data
@ApiModel("用户视图对象")
public class UserVO extends BaseEntity {

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

