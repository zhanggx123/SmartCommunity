package com.tqzl.community.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/30 17:00]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
// 示例
@RestController
@Api(tags = "小区模块接口测试")
public class TestController {
    @PostMapping("/test")
    @ApiOperation("小区模块接口测试")
    public String test1( @ApiParam("参数描述")@RequestParam("id") Long id) {
        // ...
        return "helloword"+id;
    }
}

