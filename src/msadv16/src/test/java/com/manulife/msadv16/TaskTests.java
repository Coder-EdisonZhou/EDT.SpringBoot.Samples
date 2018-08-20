package com.manulife.msadv16;

import com.manulife.msadv16.handler.Task;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTests {
    @Autowired
    private Task task;

    private static final int MAX_TIMES = 10000;

    @Test
    @SneakyThrows
    public void testTask() throws Exception {
        for (int i = 0; i < MAX_TIMES; i++) {
            task.doTaskOne();
            task.doTaskTwo();
            task.doTaskThree();

            if (i == MAX_TIMES - 1){
                System.exit(0);
            }
        }
    }
}
