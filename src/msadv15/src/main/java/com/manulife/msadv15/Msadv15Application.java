package com.manulife.msadv15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class Msadv15Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.使用@Async实现异步调用：自定义线程池
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv15Application.class, args);
	}

	@EnableAsync
	@Configuration
	class TaskToolConfig{
		@Bean("taskExecutor")
		public Executor taskExecutor() {
			// 创建一个线程池
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			// 核心线程数10：线程池创建时候初始化的线程数
			executor.setCorePoolSize(10);
			// 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
			executor.setMaxPoolSize(20);
			// 缓冲队列200：用来缓冲执行任务的队列
			executor.setQueueCapacity(200);
			// 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
			executor.setKeepAliveSeconds(60);
			// 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
			executor.setThreadNamePrefix("taskExecutor-");
			// 线程池对拒绝任务的处理策略：
			// 这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，
			// 该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；
			// 如果执行程序已关闭，则会丢弃该任务
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

			return executor;
		}
	}
}
