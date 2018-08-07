package com.manulife.msadv6;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.manulife.msadv6.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/*
 * 此示例主要演示如何通过自动配置的StringRedisTemplate对象进行Redis的读写操作
 * 但它只支持String类型，对于Object可以采用JSON序列化和反序列化的方式
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTest {
	private JSONObject json = new JSONObject();
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testSetAndGetString() throws Exception {
		stringRedisTemplate.opsForValue().set("testKey20180807", "testValue");

		Assert.assertEquals("testValue",
				stringRedisTemplate.opsForValue().get("testKey20180807"));
	}

	@Test
	public void testSetAndGetObject() throws Exception{
		User newUser = new User("Edison", 29);
		stringRedisTemplate.opsForValue().set(newUser.getUserName(),
				json.toJSONString(newUser));

		User redisUser = JSON.parseObject(stringRedisTemplate.opsForValue().get("Edison"),
				User.class);
		Assert.assertEquals(29, redisUser.getAge().longValue());
	}

	@Test
	public void testSetAndGetList() throws Exception{
		User newUser1 = new User("Edison", 29);
		User newUser2 = new User("Andy", 30);
		User newUser3 = new User("Leo", 27);

		List<User> userList = new ArrayList<>();
		userList.add(newUser1);
		userList.add(newUser2);
		userList.add(newUser3);

		stringRedisTemplate.opsForValue().set("UserList", json.toJSONString(userList));

		List<User> redisUserList = JSON.parseArray(stringRedisTemplate.opsForValue().get("UserList"),
				User.class);
		Assert.assertEquals(3, redisUserList.size());
	}
}
