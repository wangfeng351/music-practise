package com.soft1851.springboot.demo.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/3
 * @Version 1.0
 */
public class CryptoUtil {

    public static String cryptoPassword(String password, String salt) {
        String psw = DigestUtils.md5Hex(password);
        return DigestUtils.md5Hex(psw + salt);
    }

    public static String createSalt() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
