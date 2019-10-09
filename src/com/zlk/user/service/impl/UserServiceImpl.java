package com.zlk.user.service.impl;

import com.zlk.user.entity.Pagination;
import com.zlk.user.entity.User;
import com.zlk.user.entity.UserFunction;
import com.zlk.user.mapper.UserMapper;
import com.zlk.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName： UserServiceImpl
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<User> findUserAll(Pagination pagination) {
        Integer page = pagination.getPage();
        Integer limit = pagination.getLimit();
        Integer startPage = (page-1)*limit;
        pagination.setStartPage(startPage);
        return userMapper.findUserAll(pagination);
    }

    @Override
    public Integer findUserCount(Pagination pagination) {
        return userMapper.findUserCount(pagination);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer deleteUserById(Integer uid) {
        return userMapper.deleteUserById(uid);
    }

    @Override
    public Integer editUserById(User user) {
        return userMapper.editUserById(user);
    }

    @Override
    public List<UserFunction> findFunByName(String name) {
        return userMapper.findFunByName(name);
    }
}
