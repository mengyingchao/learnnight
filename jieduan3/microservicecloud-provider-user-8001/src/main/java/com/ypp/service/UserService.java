package com.ypp.service;

import com.github.pagehelper.Page;
import com.ypp.entities.User;

public interface UserService {
    public boolean add(User user);
    public User get(String username);
    public Page<User> findByPage(int pageNo, int pageSize);
}
