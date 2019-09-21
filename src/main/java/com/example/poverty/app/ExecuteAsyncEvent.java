package com.example.poverty.app;

import com.example.poverty.app.util.WebHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author ccphamy
 */
@Slf4j
@Component
public class ExecuteAsyncEvent {


    @Async
    public void checkStudent(long identify, Student student, Collection<Student> students) {
        log.info(" Thread [{}] Identify [{}] => {}", Thread.currentThread().getName(), identify, student.toBaseString());

        student.setId(identify);

        student.setPovertyInfoOne(WebHttpUtil.getCreateCardiPoverty(student.getName(), student.getIdCard()));
        student.setPovertyInfoTwo(WebHttpUtil.getSoocialAssistance(student.getName(), student.getIdCard()));

        students.add(student);
        // V操作
        ThreadControl.SIGNAL.getAndIncrement();
    }
}
