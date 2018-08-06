package com.manulife.msadv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv4Application {

	/// 此示例主要演示以下内容：
	/// 1.Spring Security的基本应用 (WebSecurityConfig)
	/// 2.JdbcTemplate访问数据库
	/// 3.Spring-JPA访问数据库
	public static void main(String[] args) {
		SpringApplication.run(Msadv4Application.class, args);
	}
}
