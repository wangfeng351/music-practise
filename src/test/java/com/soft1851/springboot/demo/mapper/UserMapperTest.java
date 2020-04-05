package com.soft1851.springboot.demo.mapper;

import com.soft1851.springboot.demo.DemoApplication;
import com.soft1851.springboot.demo.entity.User;
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
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void getByAccount() {
        User user = User.builder().email("1244353766@qq.com").build();
        System.out.println(userMapper.getByAccount(user));
    }

    public void insert() {
    }

    public void update() {
    }
}