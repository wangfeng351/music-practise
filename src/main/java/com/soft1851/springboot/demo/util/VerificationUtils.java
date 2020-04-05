package com.soft1851.springboot.demo.util;

import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/3
 * @Version 1.0
 */
public class VerificationUtils {

    public static boolean verifyEmail(String email) {
        String regEx1 = "^([a-z0-9A-Z-0-9]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return Pattern.compile(regEx1).matcher(email).matches();
    }

    public static boolean verifyPhoneNumber(String phoneNumber) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        return Pattern.compile(regExp).matcher(phoneNumber).matches();
    }

}
