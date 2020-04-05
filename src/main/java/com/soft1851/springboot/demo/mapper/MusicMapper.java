package com.soft1851.springboot.demo.mapper;

import com.soft1851.springboot.demo.entity.Music;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
public interface MusicMapper {

    /**
     * 音乐详情
     *
     * @param id
     * @return
     */
    Music getMusicById(int id);

    /**
     * 获取所有的音乐
     *
     * @return
     */
    @Select("SELECT * FROM sys_music")
    List<Music> selectAll();

    /**
     * 获取所有的音乐
     *
     * @return
     */
    @Select("SELECT name, url, singer FROM sys_music WHERE music_id=#{id}")
    List<Map<String, Object>> selectAllBy(@Param("id") int id);

    /**
     * 批量新增音乐
     *
     * @param list
     */
    @Insert("<script>" +
            "INSERT INTO sys_music VALUES " +
            "<foreach collection='list' item='item' index='index' separator=','> " +
            "(NULL, #{item.name}, #{item.thumbnail}, " +
            "#{item.url}, #{item.singer}, #{item.album}," +
            "#{item.status}, #{item.totalTime }) " +
            "</foreach>" +
            "</script>")
    void batchInsert(List<Music> list);
}
