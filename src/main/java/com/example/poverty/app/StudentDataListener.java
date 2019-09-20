package com.example.poverty.app;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义线程池已经设置为 ThreadControl.MAX,此处原子顺便做PV测试
 *
 * @author ccphamy
 */
@Slf4j
public class StudentDataListener extends AnalysisEventListener<Student> {


    @Override
    public void invoke(Student data, AnalysisContext context) {
        boolean run = false;

        while (ThreadControl.SIGNAL.get() < 1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!run) {
            // P操作
            int var = ThreadControl.SIGNAL.getAndDecrement();
            if (var < 1) {
                /**
                 * 进入等待(抢不到)
                 */
                ThreadControl.SIGNAL.getAndIncrement();
            } else {
                run = true;
                log.info(" [{}] Student => {}", var, data.toString());
                SpringBeanUtil.getBean(ExecuteAsync.class).checkStudent(var, data);
            }
        }


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

}
