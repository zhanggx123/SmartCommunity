package com.tqzl.appointment.controller;

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
@Api(tags = "预约模块测试接口")
public class TestController {
    @PostMapping("/test1")
    @ApiOperation("预约模块测试接口")
    public String test1( @ApiParam("参数描述")@RequestParam("id") Long id) {
        // ...
        return "helloword!"+id;
    }
}

