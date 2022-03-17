package com.hucheng.dao;

import com.hucheng.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回null说明用户不存在
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 用户密码
     * @return 返回null说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user 用户对象
     * @return 返回-1表示操作失败，其他表示影响行数
     */
    public int saveUser(User user);
}
