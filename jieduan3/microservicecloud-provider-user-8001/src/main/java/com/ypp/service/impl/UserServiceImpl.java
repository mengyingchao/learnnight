package com.ypp.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ypp.dao.UserDao;
import com.ypp.entities.User;
import com.ypp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean add(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User get(String username) {
        return userDao.findByName(username);
    }
    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
            return userDao.findByPage();
    }

}

