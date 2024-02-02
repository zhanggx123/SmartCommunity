package com.tqzl.redis.config;

import com.tqzl.redis.util.RedisUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author ZhangGuoxiang
 * @since 2024-01-24 14:06
 **/
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        //设置Redis key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        //设置hash key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        //设置value序列化方式
        template.setValueSerializer(RedisSerializer.json());
        template.setHashValueSerializer(RedisSerializer.json());
        return template;
    }


    @Bean
    public RedisUtil redisUtil(RedisConnectionFactory factory){
        return new RedisUtil(redisTemplate(factory));
    }
}
