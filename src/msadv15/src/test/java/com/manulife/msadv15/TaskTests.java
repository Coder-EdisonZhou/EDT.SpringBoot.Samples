package com.manulife.msadv15;

import com.manulife.msadv15.handler.ThreadPoolTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTests {

	@Autowired
	private ThreadPoolTask task;

	@Test
	public void testThreadPoolTask() throws Exception {
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();

		Thread.currentThread().join();
	}
}
