package com.tqzl.system.domain;

import com.tqzl.core.model.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/23 9:57]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@ApiModel("用户权限视图对象")
@Data
public class SysMenuRoleVO extends BaseEntity {

    @ApiModelProperty("菜单id")
    private int mid;
    @ApiModelProperty("权限id")
    private int rid;
}
