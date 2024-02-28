package com.tqzl.system.service;

import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.domain.SysMenuVO;
import com.tqzl.system.domain.dto.MenuDTO;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:29]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public interface ISysMenuService {

    /**
     * 根据菜单id查询权限
     * @param mid
     * @return
     */
    SysMenuVO queryMenuRoleById(int mid);

    /**
     * 通过菜单id删除权限
     * @param mid
     * @return
     */
    int deleteMenuRoleById(int mid);

    /**
     *新增权限视图
     * @param dto
     * @return
     */
    int insertMenu(MenuDTO dto);

    /**
     * 修改权限视图
     * @param dto
     * @return
     */
    int updateMenu(MenuDTO dto);
}
