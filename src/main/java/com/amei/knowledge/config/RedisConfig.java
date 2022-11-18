package com.amei.knowledge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {
    private final Jackson2JsonRedisSerializer<Object> jsonRedisSerializer =
            new Jackson2JsonRedisSerializer<>(Object.class);

    /**
     * 配置key,value的序列化方式
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return template;
    }


}
