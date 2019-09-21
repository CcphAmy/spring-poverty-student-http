package com.example.poverty.app.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.poverty.app.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Student Util
 *
 * @author ccphamy
 */
@Slf4j
public class StudentDataUtil {

    /**
     * 监听读取信息
     *
     * @param fileName 文件名
     * @param listener 监听对象
     */
    public static void readStudentByExcel(String fileName, Integer sheetNo, AnalysisEventListener<Student> listener) {
        log.info("Read Excel => {}", fileName);
        EasyExcel.read(fileName, Student.class, listener).sheet(sheetNo).doRead();
    }

    /**
     * 写入excel 是不是应该写入分片后合并数据
     *
     * @param fileName  文件名
     * @param sheetName sheet名称
     * @param list      数据
     */
    public static void writeResultByExcel(String fileName, String sheetName, List<Student> list) {
        log.info("write Excel => {}", fileName);
        EasyExcel.write(fileName, Student.class).sheet(sheetName).doWrite(list);
    }

}
