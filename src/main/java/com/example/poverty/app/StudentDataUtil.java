package com.example.poverty.app;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * Student Util
 * @author ccphamy
 */
public class StudentDataUtil {

    /**
     * 监听读取信息
     * @param fileName 文件名
     * @param listener 监听对象
     */
    public static void readStudentByExcel(String fileName, AnalysisEventListener<Student> listener) {
        EasyExcel.read(fileName, Student.class,listener).sheet().doRead();
    }

//    public static void writeResultByExcel(String fileName, String sheet ,)

}
