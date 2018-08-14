package com.manulife.msadv8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Msadv8Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.Spring Boot中的事务管理（JPA @Transactional注解）
	 * 2.使用Flyway管理数据库版本（请新建一个数据库来使用Flyway，否则会报错）
	 * 3.使用LDAP统计管理用户信息
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv8Application.class, args);
	}
}
