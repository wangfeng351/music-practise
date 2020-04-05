package com.soft1851.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.springboot.demo.entity.User;
import com.soft1851.springboot.demo.service.UserService;
import com.soft1851.springboot.demo.util.ResponseObject1;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/3
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/signIn")
    public String signIn(@RequestBody User user) {
        int code = 1;
        if(userService.signIn(user) == null ){
            code = 2;
        }
        ResponseObject1 ro = new ResponseObject1(code, "成功", userService.signIn(user));
        return JSON.toJSONString(ro);
    }

    @PostMapping(value = "/signUp")
    public String signUp(@RequestBody User user){
        ResponseObject1 ro = new ResponseObject1(1, "成功", userService.signUp(user));
        return JSON.toJSONString(ro);
    }
}
