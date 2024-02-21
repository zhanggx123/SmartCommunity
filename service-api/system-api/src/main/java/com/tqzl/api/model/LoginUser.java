package com.tqzl.api.model;

import com.tqzl.api.domain.UserVO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/20 15:20]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Data
@Accessors(chain = true)
public class LoginUser implements Serializable {

    private static final long serialVersionUID = -2808962847816716527L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

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
    private UserVO userVO;

}
