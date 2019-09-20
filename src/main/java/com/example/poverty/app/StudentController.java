package com.example.poverty.app;

import org.springframework.stereotype.Controller;

/**
 * @author ccphamy
 */
@Controller
public class StudentController {


    public void run(String fileName) {
        StudentDataUtil.readStudentByExcel(fileName, new StudentDataListener());
    }
}
