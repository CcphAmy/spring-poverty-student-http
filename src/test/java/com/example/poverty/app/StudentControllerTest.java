package com.example.poverty.app;

import com.example.poverty.app.util.OkHttpUtil;
import com.example.poverty.app.util.StudentDataUtil;
import com.example.poverty.app.util.WebHttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccphamy
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Test
    public void testOkHttp() throws IOException {
        Map<String,String> map = new HashMap<>(2);
        map.put("inputName","王雅文");
        map.put("inputId","440112200500000000");
        String res = OkHttpUtil.postFrom("http://210.76.68.130:8080/fpy/antiPoverty/userInfo/getPopInfoByIdCardAndName",map);
        System.out.println(res);
    }

}