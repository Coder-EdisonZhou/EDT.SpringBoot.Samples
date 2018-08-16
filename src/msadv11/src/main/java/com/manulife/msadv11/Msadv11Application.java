package com.manulife.msadv11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv11Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.使用log4j记录日志
	 * 2.使用log4j进行多环境（dev,test,prod）不同日志（INFO,DEBUG,ERROR）级别的控制
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv11Application.class, args);
	}
}
