package com.soft1851.springboot.demo.service;

import com.soft1851.springboot.demo.entity.UserMusic;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
public interface UserMusicService {

    /**
     * 新增收藏
     * @param userMusic
     * @return
     */
    void insert(UserMusic userMusic);

    /**
     * 批量新增收藏
     * @param list
     * @return
     */
    void batchInsert(List<UserMusic> list);

    /**
     * 批量取消收藏
     * @param idList
     * @return
     */
    void batchDelete(List<Integer> idList);

    /**
     * 当前用户收藏歌单
     * @return
     */
    List<Map<String, Object>> getUserMusicByUserId(String userId);

    /**
     * 当前收藏该首歌的所有用户信息
     * @return
     */
    List<Map<String, Object>> getUserMusicByMusic(int musicId);
}
