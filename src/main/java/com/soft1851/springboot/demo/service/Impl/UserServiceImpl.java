package com.soft1851.springboot.demo.service.Impl;

import com.soft1851.springboot.demo.entity.User;
import com.soft1851.springboot.demo.mapper.UserMapper;
import com.soft1851.springboot.demo.service.UserService;
import com.soft1851.springboot.demo.util.CryptoUtil;
import com.soft1851.springboot.demo.util.VerificationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/2
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String signUp(User user) {
        User user1 = userMapper.getByAccount(user);
        if (user1 != null) {
            return "该账号已存在";
        }
        String salt = CryptoUtil.createSalt();
        user.setPassword(CryptoUtil.cryptoPassword(user.getPassword(), salt));
        user.setSalt(salt);
        user.setStatus(1);
        user.setBinding(0);
        user.setCredits(0);
        user.setCreateTime(LocalDateTime.now());
        user.setLastLoginTime(LocalDateTime.now());
        userMapper.insert(user);
        System.out.println(user.getPassword());
        return "注册成功";
    }

    @Override
    public User signIn(User user) {
        User user1 = userMapper.getByAccount(user);
        System.out.println(user1.getPassword().length());
        User user2 = new User();
        if (user1 != null) {
            String password = user1.getPassword();
            String userPassword = CryptoUtil.cryptoPassword(user.getPassword(), user1.getSalt());
            System.out.println(userPassword.length());
            if (userPassword.equals(password)) {
                LocalDateTime date = LocalDateTime.now();
                if (user1.getLastLoginTime().getDayOfMonth() == date.getDayOfMonth()) {
                    user2.setCredits(user1.getCredits());
                } else {
                    user2.setCredits(user1.getCredits() + 5);
                }
                user2.setPhoneNumber(user1.getPhoneNumber());
                user2.setEmail(user1.getEmail());
                user2.setLastLoginTime(date);
                userMapper.update(user2);
                return user1;
            } else {
                return new User();
            }

        }
        return new User();
    }

    public static void main(String[] args) {
        User user = User.builder().build();
        new UserServiceImpl().signUp(user);
    }
}
