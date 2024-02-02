package com.tqzl.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan(basePackages = {
        "com.tqzl"
})
public class ServiceAppointmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAppointmentApplication.class, args);
    }

}
