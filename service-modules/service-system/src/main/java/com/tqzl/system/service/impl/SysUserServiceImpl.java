package com.tqzl.system.service.impl;

import com.tqzl.api.domain.UserVO;
import com.tqzl.system.mapper.SysUserMapper;
import com.tqzl.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/20 11:52]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public UserVO queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

    @Override
    public UserVO queryUserById(Long userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public int updateUserById(Long userId) {
        return userMapper.updateUserById(userId);
    }
}
