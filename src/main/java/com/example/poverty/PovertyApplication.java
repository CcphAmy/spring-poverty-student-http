package com.example.poverty;

import com.example.poverty.app.StudentDataListener;
import com.example.poverty.app.ThreadControl;
import com.example.poverty.app.util.StudentDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author ccphamy
 */
@Slf4j
@EnableAsync
@SpringBootApplication
public class PovertyApplication implements ApplicationRunner {

    @Lazy
    @Autowired
    private ApplicationContext applicationContext;

    private static final int PARAMS_NUM = 2;

    public static void main(String[] args) {
        SpringApplication.run(PovertyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
        /////////////////////////////////
        // jar 包启动
        /////////////////////////////////
        if (args.getSourceArgs().length < PARAMS_NUM) {
            log.error("main 入参错误，执行： java -jar 读取的Excel 生成的Excel目录(文件名自动生成)，\n " +
                    "例如：java -jar poverty-0.0.1-SNAPSHOT.jar /home/ccphamy/Desktop/test.xlsx /home/ccphamy/Desktop/");
            SpringApplication.exit(applicationContext, () -> 1);
        } else {
            ThreadControl.READ_EXCEL_PATH = args.getSourceArgs()[1];
            StudentDataUtil.readStudentByExcel(args.getSourceArgs()[0], 0, new StudentDataListener());
        }

        /////////////////////////////////
        // 自行 Debug or run
        /////////////////////////////////

        // StudentDataUtil.readStudentByExcel("/home/ccphamy/Desktop/在校生需核查名单.xls", 1, new StudentDataListener());
        // StudentDataUtil.readStudentByExcel("/home/ccphamy/Desktop/在校生需核查名单.xls", 2, new StudentDataListener());
    }
}
