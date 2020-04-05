package com.soft1851.springboot.demo.domain;

import com.soft1851.springboot.demo.entity.UserMusic;
import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@Data
public class UserMusicVo {
    private List<UserMusic> userMusics;
    private List<Integer> idList;
}
