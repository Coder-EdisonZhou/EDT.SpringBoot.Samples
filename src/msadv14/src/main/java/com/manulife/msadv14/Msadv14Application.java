package com.manulife.msadv14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync // 要使用@Async注解，需使用@EnableAsync来启用Async
public class Msadv14Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.使用@Scheduled创建定时任务
	 * 2.使用@Async实现异步调用
	 */
	public static void main(String[] args) {

		SpringApplication.run(Msadv14Application.class, args);
	}
}
