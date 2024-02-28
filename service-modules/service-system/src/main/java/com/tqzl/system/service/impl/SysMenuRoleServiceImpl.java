package com.tqzl.system.service.impl;

import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.domain.SysMenuVO;
import com.tqzl.system.domain.dto.MenuRoleDTO;
import com.tqzl.system.mapper.SysMenuRoleMapper;
import com.tqzl.system.service.ISysMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:31]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Service
public class SysMenuRoleServiceImpl implements ISysMenuRoleService {

    private final SysMenuRoleMapper menuRoleMapper;

    public SysMenuRoleServiceImpl(SysMenuRoleMapper menuRoleMapper) {
        this.menuRoleMapper = menuRoleMapper;
    }

    @Override
    public SysMenuRoleVO queryMenuById(int menuId) {
        return menuRoleMapper.queryMenuRoleById(menuId);
    }

    @Override
    public int deleteMenuById(int menuId) {
        return menuRoleMapper.deleteMenuRoleById(menuId);
    }

    @Override
    public int insertMenuRole(MenuRoleDTO dto) {
        return menuRoleMapper.insertMenuRole(dto);
    }

    @Override
    public int updateMenuRole(MenuRoleDTO dto) {
        return menuRoleMapper.updateMenuRole(dto);
    }
}
