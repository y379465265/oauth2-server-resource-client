package com.izejin.utils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptUtil {

    @Test
    public void encryptPwd(){
        String password = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        password = encoder.encode("123456");
        System.out.println(password);
    }
}
