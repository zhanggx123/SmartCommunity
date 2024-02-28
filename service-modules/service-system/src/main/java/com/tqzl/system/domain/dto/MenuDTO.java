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
@ApiModel("菜单/权限数据传输对象")
public class MenuDTO {

    @ApiModelProperty("菜单/按钮id")
    private int menuId;
    @ApiModelProperty("上级菜单id")
    private int parentId;
    @ApiModelProperty("菜单/按钮名称")
    private String menuName;
    @ApiModelProperty("对应路由path")
    private String path;
    @ApiModelProperty("对应路由组件component")
    private String component;
    @ApiModelProperty("权限标识")
    private String perms;
    @ApiModelProperty("图标")
    private String icon;
    @ApiModelProperty("类型 0菜单1按钮")
    private String type;
    @ApiModelProperty("排序")
    private int orderNum;

}
