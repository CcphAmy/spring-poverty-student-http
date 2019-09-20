package com.example.poverty.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author ccphamy
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Resource
    private StudentController studentController;

    @Test
    public void run() {
        studentController.run("/home/ccphamy/Desktop/test.xls");
    }
}