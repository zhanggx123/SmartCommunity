package com.tqzl.system.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/28 10:07]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Data
@ApiModel("角色传输对象")
public class RoleDTO {

    @ApiModelProperty("角色id")
    private int roleId;
    @ApiModelProperty("角色名称")
    private String roleName;

}
