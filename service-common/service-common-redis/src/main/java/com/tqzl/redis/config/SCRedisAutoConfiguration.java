package com.tqzl.redis.config;

import com.tqzl.redis.util.RedisUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/24 16:48]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
@Configuration
@ConditionalOnMissingBean(RedisConnectionFactory.class)
public class SCRedisAutoConfiguration {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate template = new RedisTemplate<>();
        // 设置redis key 的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // 设置hash key 的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置hash value 的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        // 设置hash key 的序列化方式
        template.setHashKeySerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisUtil redisUtil(RedisConnectionFactory factory){
        return new RedisUtil(redisTemplate(factory));
    }

}
