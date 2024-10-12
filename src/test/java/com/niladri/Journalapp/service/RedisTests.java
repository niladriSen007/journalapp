package com.niladri.Journalapp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Disabled
	@Test
	public void testRedis() {
		redisTemplate.opsForValue().set("email", "niladri@email.com");
		System.out.println(redisTemplate.opsForValue().get("email"));
	}
}
