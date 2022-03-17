package com.hucheng.test;

import com.hucheng.pojo.User;
import com.hucheng.service.UserService;
import com.hucheng.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"","",""));
    }

    @Test
    public void login() {
        userService.login(new User());
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("admin")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}