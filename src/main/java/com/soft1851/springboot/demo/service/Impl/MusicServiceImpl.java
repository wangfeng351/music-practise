package com.soft1851.springboot.demo.service.Impl;

import com.soft1851.springboot.demo.entity.Music;
import com.soft1851.springboot.demo.mapper.MusicMapper;
import com.soft1851.springboot.demo.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/5
 * @Version 1.0
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicMapper musicMapper;

    @Override
    public List<Music> selectAll() {
        return musicMapper.selectAll();
    }
}
