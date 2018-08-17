package com.manulife.msadv14;

import com.manulife.msadv14.handler.AsyncTask;
import com.manulife.msadv14.handler.SerialTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTests {

	@Autowired
	private SerialTask serialTask;

	@Test
	public void testTaskInSerial() throws Exception{
		serialTask.doTaskOne();
		serialTask.doTaskTwo();
		serialTask.doTaskThree();
	}

	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void testTaskInAsync() throws Exception{
		long start = System.currentTimeMillis();

		Future<String> task1 = asyncTask.doTaskOne();
		Future<String> task2 = asyncTask.doTaskTwo();
		Future<String> task3 = asyncTask.doTaskThree();

		while (true){
			if (task1.isDone() && task2.isDone() && task3.isDone()){
				// 三个任务都完成时推出循环
				break;
			}

			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "ms");
	}
}
