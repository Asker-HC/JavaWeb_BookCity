package com.hucheng.service;

import com.hucheng.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 判断用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示可用
     */
    public boolean existUsername(String username);
}
