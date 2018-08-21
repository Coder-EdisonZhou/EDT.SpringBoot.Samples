package com.manulife.msadv17;

import com.manulife.msadv17.handler.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TaskTests {
    @Autowired
    private Task task;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testTask() throws Exception {
        Future<String> futureTask = task.run();
        // 下面还定义了超时时间为5s，如果超时则会抛出超时异常，
        // 从而执行线程就能因为超时而释放线程池，不至于一直阻塞而占用资源
        String result = futureTask.get(5, TimeUnit.SECONDS);

        logger.info(result);
    }
}
