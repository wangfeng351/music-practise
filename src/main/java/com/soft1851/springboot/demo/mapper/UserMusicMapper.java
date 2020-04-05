package com.soft1851.springboot.demo.mapper;


import com.soft1851.springboot.demo.entity.UserMusic;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
public interface UserMusicMapper {

    /**
     * 新增用户收藏信息
     *
     * @param userMusic
     */
    @Insert("INSERT INTO sys_user_music VALUES " +
            "(NULL, #{userId}, #{musicId}, " +
            "#{favoriteStatus}")
    void insertUserMusic(@Param("userMusic") UserMusic userMusic);

    /**
     * 批量新增
     *
     * @param userMusics
     */
    @Insert("<script>" +
            "INSERT INTO sys_user_music VALUES " +
            "<foreach collection='userMusics' item='item' index='index' separator=','> " +
            "(NULL, #{item.userId}, #{item.musicId},#{item.favoriteStatus}) " +
            "</foreach>" +
            "</script>")
    int batchInsertUserMusic(@Param("userMusics") List<UserMusic> userMusics);

    /**
     * 批量取消收藏歌曲
     *
     * @param idList
     */
    @Delete("<script>" +
            "DELETE FROM sys_user_music WHERE id IN" +
            "<foreach collection='idList' item='item' index='index' open='(' separator=',' close=')'> " +
            "#{item}" +
            "</foreach>" +
            "</script>")
    void batchDeleteUserMusic(@Param("idList") List<Integer> idList);

    /**
     * 用户及当前用户收藏歌曲视图
     *
     * @param userId
     * @return
     */
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "musicList", column = "music_id",
            many = @Many(select = "com.soft1851.springboot.demo.mapper.MusicMapper.selectAllBy")),
    })
    @Select("SELECT * FROM sys_user_music WHERE user_id=#{userId}")
    List<Map<String, Object>> getUserMusicByUserId(String userId);

    /**
     * 用户及当前用户收藏歌曲视图
     *
     * @param musicId
     * @return
     */
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userList", column = "user_id",
                    many = @Many(select = "com.soft1851.springboot.demo.mapper.UserMapper.selectAllBy")),
    })
    @Select("SELECT * FROM sys_user_music WHERE music_id=#{musicId}")
    List<Map<String, Object>> getUserMusicByMusicId(int musicId);
}

