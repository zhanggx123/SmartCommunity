package com.tqzl.system.service;

import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.domain.SysMenuVO;
import com.tqzl.system.domain.dto.MenuRoleDTO;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:30]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public interface ISysMenuRoleService {

    /**
     * 通过菜单id查询权限视图
     * @param menuId
     * @return
     */
    SysMenuRoleVO queryMenuById(int menuId);

    /**
     * 通过菜单id删除权限视图
     * @param menuId
     * @return
     */
    int deleteMenuById(int menuId);

    /**
     * 新增权限
     * @param dto
     * @return
     */
    int insertMenuRole(MenuRoleDTO dto);

    /**
     * 修改权限
     * @param dto
     * @return
     */
    int updateMenuRole(MenuRoleDTO dto);

}
