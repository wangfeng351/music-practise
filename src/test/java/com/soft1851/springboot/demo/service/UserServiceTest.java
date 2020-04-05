package com.soft1851.springboot.demo.service;

import com.soft1851.springboot.demo.DemoApplication;
import com.soft1851.springboot.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void signUp() {
        User user = User.builder().username("测试1")
                .email("1244353765@qq.com")
                .phoneNumber("14752191369").build();
        System.out.println(userService.signUp(user));
    }

    @Test
    void signIn() {
        User user = User.builder()
                .phoneNumber("14752191369")
                .password("123456")
                .build();
        System.out.println(userService.signIn(user));
    }
}