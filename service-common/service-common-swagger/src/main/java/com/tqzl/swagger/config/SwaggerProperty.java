package com.tqzl.swagger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/30 16:47]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Data
@ConfigurationProperties(prefix = "tqzl-swagger")
public class SwaggerProperty {
    String author;
    String title;
    String version;
    String basePackage;
}
