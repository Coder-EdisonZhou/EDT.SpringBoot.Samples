package com.manulife.msadv16.handler;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Task {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*
     * 我们只需要在@Async注解中 指定线程池名 即可
     */
    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        //System.out.println("开始做任务1");
        logger.info("开始做任务1");
        long start = System.currentTimeMillis();
        logger.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        //System.out.println("完成任务1，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务1，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        //System.out.println("开始做任务2");
        logger.info("开始做任务2");
        long start = System.currentTimeMillis();
        logger.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        //System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务2，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        //System.out.println("开始做任务3");
        logger.info("开始做任务3");
        long start = System.currentTimeMillis();
        logger.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        //System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
        logger.info("完成任务3，耗时：" + (end - start) + "毫秒");
    }
}
