package com.tqzl.system.service.impl;

import com.tqzl.system.domain.SysMenuRoleVO;
import com.tqzl.system.mapper.SysMenuMapper;
import com.tqzl.system.mapper.SysMenuRoleMapper;
import com.tqzl.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:30]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    private final SysMenuRoleMapper menuRoleMapper;

    public SysMenuServiceImpl(SysMenuRoleMapper menuMapper) {
        this.menuRoleMapper = menuMapper;
    }

    @Override
    public SysMenuRoleVO queryMenuRoleById(int mid) {
        return menuRoleMapper.queryMenuRoleById(mid);
    }

    @Override
    public int deleteMenuRoleById(int mid) {
        return menuRoleMapper.deleteMenuRoleById(mid);
    }
}
