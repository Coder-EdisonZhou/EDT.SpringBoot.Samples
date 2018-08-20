package com.manulife.msadv15.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class ThreadPoolTask {

    public static Random random = new Random();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
     * 我们只需要在@Async注解中 指定线程池名 即可
     */
    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        //System.out.println("开始做任务1");
        logger.info("开始做任务1");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务1，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务1，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        //System.out.println("开始做任务2");
        logger.info("开始做任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务2，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        //System.out.println("开始做任务3");
        logger.info("开始做任务3");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        //System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务3，耗时：" + (end - start) + "毫秒");
    }
}
