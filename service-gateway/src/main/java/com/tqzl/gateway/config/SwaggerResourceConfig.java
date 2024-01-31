package com.tqzl.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.*;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/30 17:14]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
/**
 * 自定义Swagger的各个配置节点
 */
@Slf4j
@Component
@Primary
@AllArgsConstructor
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        // 获取所有swagger文档路由的ID
        routeLocator.getRoutes().subscribe(route -> {
            String routeId = route.getId().toLowerCase(Locale.ROOT);
            // swagger文档的路由ID中包含有：swagger-docs
            if (routeId.contains("swagger-docs")) {
                routes.add(route.getId());
            }
        });

        //过滤出配置文件中定义的路由->过滤出Path Route Predicate->根据路径拼接成api-docs路径->生成SwaggerResource
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId())).forEach(route -> {
            route.getPredicates().stream()
                    .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                    .forEach(predicateDefinition ->
                            resources.add(
                                    swaggerResource(route.getId(),
                                            predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                                    // 把路径中后面的 ** 替换成文档地址：v2/api-docs
                                                    .replace("**", "v2/api-docs"))));
        });

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        //log.info("name:{},location:{}", name, location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(SwaggerModel.getByName(name).cnName);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

    /**
     * 枚举类：中英文映射
     */
    enum SwaggerModel {
        DEFAULT("default", "默认"),
        S_1("swagger-docs-appointment", "预约接口文档"),
        S_2("swagger-docs-community", "小区接口文档");

        private String name;
        private String cnName;

        SwaggerModel(String name, String cnName) {
            this.name = name;
            this.cnName = cnName;
        }

        public static SwaggerModel getByName(String name) {
            for (SwaggerModel m : SwaggerModel.values()) {
                if (Objects.equals(m.name, name)) {
                    //if(m.code == code){
                    return m;
                }
            }
            return DEFAULT;
        }
    }
}


