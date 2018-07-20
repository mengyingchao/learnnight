package com.ypp.springcloud.controller;
import java.util.List;

import com.ypp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.github.pagehelper.Page;
@RestController
public class UserController_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/user/add")
    public boolean add(User user)
    {
        return restTemplate.postForObject(REST_URL_PREFIX + "/user/add", user, Boolean.class);
    }

    @RequestMapping(value = "/consumer/user/get/{username}")
    public User get(@PathVariable("username") String username)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + username, User.class);
    }
    @RequestMapping(value = "/consumer/user/list")
    public Page<User> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/list", Page.class);
    }
}
