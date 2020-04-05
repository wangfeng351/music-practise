package com.soft1851.springboot.demo.service;

import com.soft1851.springboot.demo.entity.Music;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
public interface MusicService {

    /**
     * 获取所有歌曲信息
     * @return list
     */
    List<Music> selectAll();
}
