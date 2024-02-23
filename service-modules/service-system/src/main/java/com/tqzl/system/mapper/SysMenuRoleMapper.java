package com.tqzl.system.mapper;

import com.tqzl.system.domain.SysMenuRoleVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:28]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Mapper
public interface SysMenuRoleMapper {

    /**
     * 根据菜单id查询权限
     * @param mid
     * @return
     */
    SysMenuRoleVO queryMenuRoleById(int mid);

    /**
     * 通过菜单id删除权限
     * @param mid
     * @return
     */
    int deleteMenuRoleById(int mid);

}