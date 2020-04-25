package com.exchangerates.repositories;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.exchangerates.utility.ExchangeStatic;

@Repository
public class RedisRateRepository {
	private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisRateRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(String id, String rate){
        hashOperations.put(ExchangeStatic.REDIS_KEY, id, rate);
    }
    public List findAll(){
        return hashOperations.values(ExchangeStatic.REDIS_KEY);
    }

    public String findById(String id){
        return (String) hashOperations.get(ExchangeStatic.REDIS_KEY, id);
    }

    public void update(String id, String rate){
        save(id, rate);
    }

    public void delete(String id){
        hashOperations.delete(ExchangeStatic.REDIS_KEY, id);
    }
}
