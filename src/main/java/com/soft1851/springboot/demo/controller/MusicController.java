package com.soft1851.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.springboot.demo.service.MusicService;
import com.soft1851.springboot.demo.util.ResponseObject1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/music")
public class MusicController {

    @Resource
    private MusicService musicService;

    @GetMapping()
    public String getAll(){
        ResponseObject1 ro = new ResponseObject1(1, "成功", musicService.selectAll());
        return JSON.toJSONString(ro);
    }
}
