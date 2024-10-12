package com.niladri.Journalapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {

	@Autowired
	private RedisTemplate redisTemplate;

	public <T> T getRedisValue(String key, Class<T> entityClass) {
		try{
			Object o = redisTemplate.opsForValue().get(key);
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(o.toString(), entityClass);
		}catch (Exception e){
			log.error("Error while getting value from redis",e);
			return null;
		}
	}

	public void setRedisValue(String key,Object value,Long ttl) {
		try{
			redisTemplate.opsForValue().set(key,value.toString(),ttl);

		}catch (Exception e){
			log.error("Error while setting value in redis",e);
		}
	}
}
