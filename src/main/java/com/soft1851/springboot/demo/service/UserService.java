package com.soft1851.springboot.demo.service;


import com.soft1851.springboot.demo.entity.User;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param user
     */
    String signUp(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User signIn(User user);
}
