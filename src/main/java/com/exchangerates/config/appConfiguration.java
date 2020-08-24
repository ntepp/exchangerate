package com.exchangerates.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class appConfiguration {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	@Value("${spring.redis.host}")
	private String redisCloudUrl;
	@Value("${spring.redis.password}")
	private String redisPassword;
	@Value("${spring.redis.port}")
	private String redisPort;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		 RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisCloudUrl, Integer.parseInt(redisPort));
		 redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
	        return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		config.setUsername(dbUsername);
		config.setPassword(dbPassword);
		return new HikariDataSource(config);
	}
}
