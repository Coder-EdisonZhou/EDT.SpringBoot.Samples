package com.manulife.msadv17.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Slf4j
@Component
public class Task {

    public static Random random = new Random();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("taskExecutor")
    /*
     * Future是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、获取结果的接口。
     * 必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
     * Future提供了三种功能：
     * 1.判断任务是否完成；
     * 2.能够中断任务；
     * 3.能够获取任务执行结果。
     */
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(10000);
        logger.info("任务开始，需要耗时：" + sleep + "ms");
        Thread.sleep(sleep);
        logger.info("完成任务");

        return new AsyncResult<>("test");
    }
}
