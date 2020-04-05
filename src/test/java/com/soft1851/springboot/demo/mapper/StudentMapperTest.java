package com.soft1851.springboot.demo.mapper;

import com.soft1851.springboot.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void selectAll() {
        System.out.println(studentMapper.selectAll());
    }
}