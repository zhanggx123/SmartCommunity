package com.tqzl.system.mapper;

import com.tqzl.system.domain.SysMenuVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:28]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Mapper
public interface SysMenuMapper {

    /**
     * 通过菜单id查询权限视图
     * @param menuId
     * @return
     */
    SysMenuVO queryMenuById(int menuId);

    /**
     * 通过菜单id删除权限视图
     * @param menuId
     * @return
     */
    int deleteMenuById(int menuId);

}
