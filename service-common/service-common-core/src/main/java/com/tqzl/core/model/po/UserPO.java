package com.tqzl.core.model.po;

import com.tqzl.core.model.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 *
 * @Author ZhangGuoXiang
 * @Date [2024/2/19 14:32]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserPO extends BaseEntity {

    private String name;
    private String password;
    private String email;
    private String avatar;
    private String address;
    private int sex;
    private String tel;

}
