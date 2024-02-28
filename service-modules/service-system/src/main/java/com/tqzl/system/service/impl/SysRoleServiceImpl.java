package com.tqzl.system.service.impl;

import com.tqzl.system.domain.SysRoleVO;
import com.tqzl.system.domain.dto.RoleDTO;
import com.tqzl.system.mapper.SysRoleMapper;
import com.tqzl.system.service.ISysRoleService;
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
public class SysRoleServiceImpl implements ISysRoleService {

    private final SysRoleMapper roleMapper;

    public SysRoleServiceImpl(SysRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public SysRoleVO queryRoleByRoleId(int roleId) {
        return roleMapper.queryRoleByRoleId(roleId);
    }

    @Override
    public int deleteRoleByRoleId(int roleId) {
        return roleMapper.deleteRoleByRoleId(roleId);
    }

    @Override
    public int insertRole(RoleDTO dto) {
        return roleMapper.insertRole(dto);
    }

    @Override
    public int updateRole(RoleDTO dto) {
        return roleMapper.updateRole(dto);
    }
}
