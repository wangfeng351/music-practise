package com.soft1851.springboot.demo.mapper;

import com.soft1851.springboot.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 登录接口
     *
     * @return boolean
     */
    @Select("SELECT * FROM sys_user WHERE email=#{email} OR phone_number=#{phoneNumber}")
    User getByAccount(User user);

    /**
     * 登录接口
     *
     * @return boolean
     */
    @Select("SELECT user_name, avatar FROM sys_user WHERE email=#{account} OR phone_number=#{account}")
    List<User> selectAllBy(@Param("account") String account);

    /**
     * 注册接口
     *
     * @param user
     */
    @Insert("INSERT INTO sys_user VALUES (NULL, #{username}, #{password}, " +
            "#{avatar}, #{salt}, #{email}, #{phoneNumber}, " +
            "#{status},#{binding},#{credits}, " +
            "#{createTime}, #{lastLoginTime})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insert(User user);

    /**
     * 修改用户的信息
     */
    @Update(" UPDATE sys_user SET credits=#{credits}, last_login_time=#{lastLoginTime} " +
            "WHERE phone_number=#{phoneNumber} OR email=#{email}")
    void update(User user);
}
