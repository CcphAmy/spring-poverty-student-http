package com.example.poverty;

import com.example.poverty.app.StudentDataListener;
import com.example.poverty.app.util.StudentDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

/**
 * @author ccphamy
 */
@EnableAsync
@SpringBootApplication
public class PovertyApplication  implements ApplicationRunner {

    @Lazy
    @Resource
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(PovertyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        StudentDataUtil.readStudentByExcel("/home/ccphamy/Desktop/在校生需核查名单.xls", 1, new StudentDataListener());
        StudentDataUtil.readStudentByExcel("/home/ccphamy/Desktop/在校生需核查名单.xls", 2, new StudentDataListener());
        SpringApplication.exit(applicationContext, () -> 0);
    }
}
