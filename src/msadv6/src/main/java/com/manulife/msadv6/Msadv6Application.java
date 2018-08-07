package com.manulife.msadv6;

import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongoPlus // => MongoDB配置增强 => spring4all package
@SpringBootApplication
public class Msadv6Application {

	/// 此示例主要演示以下内容：
	/// 1.Redis的基本使用
	/// 2.MongoDB的基本使用
	/// 3.MongoDB的配置增强（连接池等）
	public static void main(String[] args) {
		SpringApplication.run(Msadv6Application.class, args);
	}
}
