package com.tqzl.system.mapper;

import com.tqzl.system.domain.SysRoleVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/22 17:27]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Mapper
public interface SysRoleMapper {


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
