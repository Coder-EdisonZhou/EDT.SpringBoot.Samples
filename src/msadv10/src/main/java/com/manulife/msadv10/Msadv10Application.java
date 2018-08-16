package com.manulife.msadv10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Msadv10Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.缓存支持（2）：使用Redis做集中式缓存
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv10Application.class, args);
	}
}
