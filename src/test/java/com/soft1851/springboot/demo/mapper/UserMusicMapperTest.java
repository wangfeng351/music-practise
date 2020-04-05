package com.soft1851.springboot.demo.mapper;

import com.soft1851.springboot.demo.DemoApplication;
import com.soft1851.springboot.demo.entity.UserMusic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@SpringBootTest(classes = DemoApplication.class)
class UserMusicMapperTest {
    @Resource
    private UserMusicMapper userMusicMapper;

    @Test
    void insertUserMusic() {

    }

    @Test
    void batchInsertUserMusic() {
        List<UserMusic> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            UserMusic userMusic = UserMusic.builder()
                    .musicId(i)
                    .favoriteStatus(1)
                    .build();
            list.add(userMusic);
        }
        userMusicMapper.batchInsertUserMusic(list);
    }

    @Test
    void batchDeleteUserMusic() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            list.add(i);
        }
        userMusicMapper.batchDeleteUserMusic(list);
    }

    @Test
    void getUserMusicByUserId() {
        System.out.println(userMusicMapper.getUserMusicByUserId("1"));
    }

    @Test
    void getUserMusicByMusicId() {
        System.out.println(userMusicMapper.getUserMusicByMusicId(9));
    }
}