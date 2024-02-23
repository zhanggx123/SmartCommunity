package com.tqzl.system.service;

import com.tqzl.system.domain.SysRoleVO;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:29]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public interface ISysRoleService {

    /**
     * 通过角色id查询角色
     * @param roleId
     * @return
     */
    SysRoleVO queryRoleByRoleId(int roleId);

    /**
     * 通过角色id删除角色
     * @param roleId
     * @return
     */
    int deleteRoleByRoleId(int roleId);
}
