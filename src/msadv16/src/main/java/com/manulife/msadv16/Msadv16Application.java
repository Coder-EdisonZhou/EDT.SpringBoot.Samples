package com.manulife.msadv16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class Msadv16Application {

	/*
	 * 此示例主要演示以下内容：
	 * 1.使用@Async实现异步调用：ThreadPoolTaskScheduler线程池的优雅关闭
	 */
	public static void main(String[] args) {
		SpringApplication.run(Msadv16Application.class, args);
	}

	@EnableAsync
	@Configuration
	class TaskToolConfig{
		@Bean("taskExecutor")
		public Executor taskExecutor() {
			// 创建一个线程池
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			// 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
			executor.setMaxPoolSize(20);
			// 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
			executor.setThreadNamePrefix("taskExecutor-");

			// ↓↓↓↓ 下面两个设置如果不添加，测试会不通过！
			// 设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
			// 这样这些异步任务的销毁就会先于Redis线程池的销毁
			executor.setWaitForTasksToCompleteOnShutdown(true);
			// 设置线程池中任务的等待时间
			// 如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
			executor.setAwaitTerminationSeconds(60);

			return executor;
		}
	}
}
