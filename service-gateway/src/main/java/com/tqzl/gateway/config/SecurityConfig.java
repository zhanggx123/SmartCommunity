package com.tqzl.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/2/4 14:29]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${swagger.username}")
    private String username;
    @Value("${swagger.password}")
    private String password;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange()
                .pathMatchers("/swagger-ui/index.html").authenticated()
                .pathMatchers("/swagger-resources/**").authenticated()
                .pathMatchers("/v2/api-docs").authenticated()
                .pathMatchers("/tqzl-appointment/v2/api-docs").authenticated()
                .pathMatchers("/tqzl-community/v2/api-docs").authenticated()
                .pathMatchers("/webjars/**").authenticated()
                .pathMatchers("/doc.html").authenticated()
                .anyExchange().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf().disable()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return  NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withUsername(username)
                .password(password)
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }
}
