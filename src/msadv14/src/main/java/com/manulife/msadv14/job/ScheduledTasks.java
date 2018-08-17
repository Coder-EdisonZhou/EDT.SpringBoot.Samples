package com.manulife.msadv14.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 30000) // 每隔30秒输出当前时间
    /*
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     */
    // 当然，还可以通过cron表达式定义规则，如@Scheduled(cron="*/5 * * * * *")
    public void reportCurrentTime(){
        System.out.println("Current Time : " + dateFormat.format(new Date()));
    }
}
