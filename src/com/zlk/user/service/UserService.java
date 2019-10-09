package com.zlk.user.service;

import com.zlk.user.entity.Pagination;
import com.zlk.user.entity.User;
import com.zlk.user.entity.UserFunction;

import java.util.List;

/**
 * @ClassName： UserService
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:21
 */
public interface UserService {
    /**
     * 登录验证
     */
    User findUserByNameAndPwd(User user);
    /**
     * 姓名查找用户
     */
    User findUserByName(String name);
    /**
     * 查询所有用户
     */
    List<User> findUserAll(Pagination pagination);
    /**
     * 查询条数
     */
    Integer findUserCount(Pagination pagination);
    /**
     * 增加用户
     */
    Integer addUser(User user);
    /**
     * 删除用户
     */
    Integer deleteUserById(Integer uid);
    /**
     * 修改用户信息
     */
    Integer editUserById(User user);
    /**
     *根据姓名查询权限名
     */
    List<UserFunction> findFunByName(String name);
}
