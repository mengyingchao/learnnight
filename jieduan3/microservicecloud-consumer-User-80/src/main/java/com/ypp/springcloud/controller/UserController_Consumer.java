package com.ypp.springcloud.controller;
import java.util.List;

import com.ypp.entities.User;
import com.ypp.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController_Consumer {
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/user/add")
    public boolean add(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        Object o=   session.getAttribute("user");
        User user=null;
     if(o instanceof  User){
        user=(User) o;
     }
        String header=MD5Util.generatePassword(user.toString());
        session.setAttribute("header",header);
        return restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, Boolean.class);
    }

    @RequestMapping(value = "/consumer/user/get/{username}")
    public User get(@PathVariable("username") String username)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + username, User.class);
    }
    @RequestMapping(value = "/consumer/user/findByPage/{pageNum}/{pageSize}")
    public Page<User> findByPage(int pageNum,int pageSize)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/findByPage/"+pageNum+"/"+pageSize, Page.class);
    }
}
