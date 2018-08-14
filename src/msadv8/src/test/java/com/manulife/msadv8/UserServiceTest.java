package com.manulife.msadv8;

import com.manulife.msadv8.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * 此单元测试主要用于演示Flyway的介入使用：
 * 1.第一次运行测试，Flyway检测到需要运行版本脚本来初始化数据库
 * 	 因此执行了（resources/db/V1.0__BaseVersion.sql）从而创建了user表
 * 2.第二次运行测试，Flyway检测到初始化脚本已经执行过就不再执行脚本了
 * 3.第三次运行之前，更改脚本中name字段的长度从20到25，运行时会报以下错误：
 * Caused by: org.flywaydb.core.api.FlywayException: Validate failed: Migration checksum mismatch for migration version 1.0
-> Applied to database : -338184704
-> Resolved locally    : 1332515276
 * 这是因为初始化脚本的改动导致Flyway校验失败，认为当前的脚本与上一次执行的内容不同
 * 所以提示报错并终止程序，以免造成更严重的数据结构破坏
 */
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
