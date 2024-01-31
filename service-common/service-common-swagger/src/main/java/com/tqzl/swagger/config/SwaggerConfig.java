package com.tqzl.swagger.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/30 16:46]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Configuration
//@EnableWebMvc
@EnableConfigurationProperties(SwaggerProperty.class)
public class SwaggerConfig {
    @Resource
    SwaggerProperty swaggerProperty;

    /**
     * 配置Swagger具体参数
     *
     * @return
     */
    @Bean
    public Docket docket(Environment environment) {
        // 允许启用Swagger的环境
        //Profiles profile = Profiles.of("dev","test");
        // 判断当前环境与指定环境是否一致
        //boolean b = environment.acceptsProfiles(profile);

        //return new Docket(DocumentationType.OAS_30)
        return new Docket(DocumentationType.SWAGGER_2)
                //.apiInfo(apiInfo("tqzl", "搜索服务", "v3.0"))
                .apiInfo(apiInfo(swaggerProperty.getAuthor(), swaggerProperty.getTitle(), swaggerProperty.getVersion()))
                // 根据当前环境判断是否启用Swagger
                //.enable(b)
                //.enable(true)
                //.groupName("A")
                // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .select()
                // 只扫描特定包下的接口
                .apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage()))
                //.apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.none())
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                //.paths(PathSelectors.)
                .build();
    }

    /**
     * 自定义API文档信息
     *
     * @return
     */
    private ApiInfo apiInfo(String author, String title, String version) {
        // 作者信息
        Contact contact = new Contact(author, "", "");

        return new ApiInfo(
                title + " API 文档",
                "",
                version,
                "",
                contact,
                "",
                "",
                new ArrayList());
    }

}
