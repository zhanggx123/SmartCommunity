package com.tqzl.system.service;

import com.tqzl.api.domain.UserVO;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/20 11:27]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public interface ISysUserService {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public UserVO queryUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public UserVO queryUserById(Long userId);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    public int updateUserById(Long userId);

}
