package com.manulife.msadv18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Msadv18Application {

	/*
	 * 该示例主要演示以下内容：
	 * 使用JavaMailSender实现邮件发送，包括：
	 * 1.简单文本邮件
	 * 2.带附件的邮件
	 * 3.带嵌入资源的邮件
	 * 4.基于Thymeleaf模板的邮件
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv18Application.class, args);
	}
}
