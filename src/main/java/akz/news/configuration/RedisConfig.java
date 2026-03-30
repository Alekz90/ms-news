package akz.news.configuration;

import akz.news.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Slf4j
@EnableCaching
@Configuration
public class RedisConfig {

  @Value("${spring.data.redis.host}")
  private String host;
  @Value("${spring.data.redis.port}")
  private Integer port;
  @Value("${spring.cache.redis.time-to-live}")
  private String timeToLive;

  @Bean
  JedisConnectionFactory  jedisConnectionFactory() {
    return new JedisConnectionFactory(new RedisStandaloneConfiguration(this.host, this.port));
  }

  @Bean
  RedisCacheManager cacheManager(JedisConnectionFactory connectionFactory) {

    RedisCacheConfiguration defaults = RedisCacheConfiguration.defaultCacheConfig()
        .serializeKeysWith(
            RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string())
        )
        .serializeValuesWith(
            RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json())
        )
        .entryTtl(Util.getTimeToLive(this.timeToLive))
        .enableTimeToIdle();

    return RedisCacheManager.builder(connectionFactory)
        .cacheDefaults(defaults)
        .build();
  }
}
