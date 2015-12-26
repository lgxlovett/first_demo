package com.lgx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lgx.dao.UserDao;
import com.lgx.model.User;
import com.lgx.service.UserService;
import com.lgx.util.CommonUtil;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public void addUser(User user) {
        CommonUtil.newStandard(user);
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        CommonUtil.updateStandard(user);
        userDao.updateUser(user);
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

}
