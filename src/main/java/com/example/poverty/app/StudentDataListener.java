package com.example.poverty.app;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.poverty.app.util.SpringBeanUtil;
import com.example.poverty.app.util.StudentDataUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程池已经设置为 ThreadControl.MAX
 * 此处原子顺便做PV测试
 *
 * @author ccphamy
 */
@Slf4j
public class StudentDataListener extends AnalysisEventListener<Student> {

    private AtomicLong identify = new AtomicLong(0);

    /**
     * 学生信息
     */
    private List<Student> students = Collections.synchronizedList(new LinkedList<Student>());

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
                 * 进入等待(抢不到)，继续阻塞
                 */
                ThreadControl.SIGNAL.getAndIncrement();
            } else {
                run = true;
                SpringBeanUtil.getBean(ExecuteAsyncEvent.class).checkStudent(identify.getAndIncrement(), data, students);
            }
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("总共读取到数据总数 => {}", identify.get());

        while (students.size() != identify.get()) {

            log.info("等待所有线程执行完毕... 当前状态 => {} => {}", identify.get(), students.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (students.size() != 0) {
            StudentDataUtil.writeResultByExcel(ThreadControl.READ_EXCEL_PATH + System.nanoTime() + ".xlsx", "sheet", students);
            return;
        }
        log.error("No Data");
    }

}
