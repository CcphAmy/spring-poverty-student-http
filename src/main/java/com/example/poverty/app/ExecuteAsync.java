package com.example.poverty.app;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ccphamy
 */
@Component
public class ExecuteAsync {


    @Async
    public void checkStudent(int i,Student student) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // V操作
        ThreadControl.SIGNAL.getAndIncrement();
    }
}
