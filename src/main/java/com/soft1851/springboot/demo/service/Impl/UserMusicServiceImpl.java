package com.soft1851.springboot.demo.service.Impl;

import com.soft1851.springboot.demo.entity.UserMusic;
import com.soft1851.springboot.demo.mapper.UserMusicMapper;
import com.soft1851.springboot.demo.service.UserMusicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserMusicServiceImpl implements UserMusicService {
    @Resource
    private UserMusicMapper mapper;


    @Override
    public void insert(UserMusic userMusic) {
        mapper.insertUserMusic(userMusic);
    }

    @Override
    public void batchInsert(List<UserMusic> list) {
        mapper.batchInsertUserMusic(list);
    }

    @Override
    public void batchDelete(List<Integer> idList) {
        mapper.batchDeleteUserMusic(idList);
    }

    @Override
    public List<Map<String, Object>> getUserMusicByUserId(String userId) {
        return mapper.getUserMusicByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getUserMusicByMusic(int musicId) {
        return mapper.getUserMusicByMusicId(musicId);
    }
}
