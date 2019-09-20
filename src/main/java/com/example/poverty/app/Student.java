package com.example.poverty.app;

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
    private String name;
    /**
     *  身份证
     */
    private String idCard;
    /**
     * 学院
     */
    private String college;
    /**
     * 班级
     */
    private String grade;
    /**
     * 第一个网页
     */
    private String povertyInfoOne;
    /**
     * 第二个网页
     */
    private String povertyInfoTwo;
}
