package com.ypp.dao;

import com.github.pagehelper.Page;
import com.ypp.entities.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDao {
    public User  findByName(String username);
    public boolean addUser(User user);
    public Page<User> findByPage();;
}
