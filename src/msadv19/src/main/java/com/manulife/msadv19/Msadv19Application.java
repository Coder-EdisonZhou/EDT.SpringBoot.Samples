package com.manulife.msadv19;

import com.manulife.msadv19.domain.Events;
import com.manulife.msadv19.domain.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Msadv19Application implements CommandLineRunner {

	/*
	 * 此示例主要演示以下内容：
	 * 1.自定义Banner（关注resources目录下的txt文件）
	 * 2.使用Spring StateMachine框架实现状态机
	 * 3.使用exclude排除不必要的自动化配置的加载（关注SpringBootApplication注解）
	 */
	public static void main(String[] args) {

		SpringApplication.run(Msadv19Application.class, args);
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception{
		stateMachine.start();					// 创建这个订单流程，初始状态UNPAID
		stateMachine.sendEvent(Events.PAY);		// 执行支付操作事件
		stateMachine.sendEvent(Events.RECEIVE); // 执行收货操作事件
	}
}
