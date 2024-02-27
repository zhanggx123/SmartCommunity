package com.tqzl.system.handler;

import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.domain.SysMenuVO;
import com.tqzl.system.domain.SysRoleVO;
import com.tqzl.system.service.ISysMenuRoleService;
import com.tqzl.system.service.ISysMenuService;
import com.tqzl.system.service.ISysRoleService;
import com.tqzl.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 菜单角色控制器
 *
 * @Author ZhangGuoXiang
 * @Date [2024/2/27 11:02]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Component
public class MenuRoleHandler {

    private final ISysMenuRoleService menuRoleService;
    private final ISysMenuService menuService;
    private final ISysRoleService roleService;

    public MenuRoleHandler(ISysMenuRoleService menuRoleService, ISysMenuService menuService, ISysRoleService roleService) {
        this.menuRoleService = menuRoleService;
        this.menuService = menuService;
        this.roleService = roleService;
    }

    public SysMenuVO queryMenuById(int menuId){
        return menuService.queryMenuRoleById(menuId);
    }

    public int deleteMenuById(int menuId){
        return menuService.deleteMenuRoleById(menuId);
    }

    public SysMenuRoleVO queryMenuRoleById(int mid){
        return menuRoleService.queryMenuById(mid);
    }

    public int deleteMenuRoleById(int mid){
        return menuRoleService.deleteMenuById(mid);
    }

    public SysRoleVO queryRoleByRoleId(int roleId){
        return roleService.queryRoleByRoleId(roleId);
    }

    public int deleteRoleByRoleId(int roleId){
        return roleService.deleteRoleByRoleId(roleId);
    }



}
