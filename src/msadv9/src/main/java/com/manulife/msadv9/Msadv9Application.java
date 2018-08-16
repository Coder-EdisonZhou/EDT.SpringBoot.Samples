package com.manulife.msadv9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // => 开启缓存功能，Spring Boot会根据以下顺序去侦测Cache Provider
/*
 * Generic, JCache, EhCache, Hazelcast
 * Redis, Guava, Simple
 * 除了顺序侦测之外，还可以通过配置属性spring.cache.type来强制指定
 */
public class Msadv9Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.缓存支持（1.1）：注解配置
	 * 2.缓存支持（1.2）：EhCache使用
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv9Application.class, args);
	}
}
