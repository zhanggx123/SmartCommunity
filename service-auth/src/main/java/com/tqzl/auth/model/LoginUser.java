package com.tqzl.auth.model;

import com.tqzl.auth.model.domain.UserDO;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/29 13:18]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Data
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 2038524930011312142L;


    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private Long userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 角色列表
     */
    private Set<String> roles;

    /**
     * 用户信息
     */
    private UserDO sysUser;
}
