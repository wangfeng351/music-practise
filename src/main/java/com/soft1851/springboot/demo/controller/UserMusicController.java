package com.soft1851.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.springboot.demo.domain.UserMusicVo;
import com.soft1851.springboot.demo.entity.UserMusic;
import com.soft1851.springboot.demo.service.UserMusicService;
import com.soft1851.springboot.demo.util.ResponseObject1;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/userMusic")
public class UserMusicController {
    @Resource
    private UserMusicService userMusicService;

    @PutMapping()
    public String insert(@RequestBody UserMusic userMusic){
        userMusicService.insert(userMusic);
        ResponseObject1 ro = new ResponseObject1(1, "成功", "");
        return JSON.toJSONString(ro);
    }

    @PutMapping("/list")
    public String batchInsert(@RequestBody UserMusicVo userMusic){
        userMusicService.batchInsert(userMusic.getUserMusics());
        ResponseObject1 ro = new ResponseObject1(1, "成功", "");
        return JSON.toJSONString(ro);
    }

    @DeleteMapping()
    public String batchDelete(@RequestBody UserMusicVo userMusicVo){
        userMusicService.batchDelete(userMusicVo.getIdList());
        ResponseObject1 ro = new ResponseObject1(1, "成功", "");
        return JSON.toJSONString(ro);
    }

    @GetMapping("/user/{userId}")
    public String getByUserId(@PathVariable String userId){
        ResponseObject1 ro = new ResponseObject1(1, "成功", userMusicService.getUserMusicByUserId(userId));
        return JSON.toJSONString(ro);
    }

    @GetMapping("/music/{musicId}")
    public String getByMusicId(@PathVariable int musicId){
        ResponseObject1 ro = new ResponseObject1(1, "成功", userMusicService.getUserMusicByMusic(musicId));
        return JSON.toJSONString(ro);
    }
}
