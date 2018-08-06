package com.manulife.msadv4;

import com.manulife.msadv4.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userSerivce;

	@Before
	public void setUp(){
		// 准备工作：清空user表
		userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception{
		// 01.插入5个用户
		userSerivce.create("aaa",1);
		userSerivce.create("bbb", 2);
		userSerivce.create("ccc",3);
		userSerivce.create("ddd",4);
		userSerivce.create("eee", 5);

		// 02.查数据库，这时应该有5个用户
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 03.删除两个用户
		userSerivce.deleteByName("aaa");
		userSerivce.deleteByName("ddd");

		// 04.查数据库，这时应该有3个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
	}
}
