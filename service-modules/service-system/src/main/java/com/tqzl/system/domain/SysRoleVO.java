package com.tqzl.system.domain;

import com.tqzl.core.model.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/23 9:37]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@ApiModel("角色视图对象")
@Data
public class SysRoleVO extends BaseEntity {

    @ApiModelProperty("角色id")
    private int roleId;
    @ApiModelProperty("角色名称")
    private String roleName;

}
