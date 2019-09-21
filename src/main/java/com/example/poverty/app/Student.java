package com.example.poverty.app;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author ccphamy
 */
@Data
@ToString
public class Student {
    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名" ,index = 0)
    private String name;
    /**
     *  身份证
     */
    @ExcelProperty(value = "身份证" ,index = 1)
    private String idCard;
    /**
     * 学院
     */
    @ExcelProperty(value = "上课院系" ,index = 2)
    private String college;
    /**
     * 班级
     */
    @ExcelProperty(value = "班级" ,index = 3)
    private String grade;
    /**
     * 第一个网页
     */
    @ExcelProperty(value = "建档立卡" ,index = 4)
    private String povertyInfoOne;
    /**
     * 第二个网页
     */
    @ExcelProperty(value = "社会救助" ,index = 5)
    private String povertyInfoTwo;
    /**
     * 读取顺序
     */
    @ExcelProperty(value = "读取顺序" ,index = 6)
    private Long id;

    public String toBaseString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
