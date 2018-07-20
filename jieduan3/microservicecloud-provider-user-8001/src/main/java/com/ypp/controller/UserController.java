package com.ypp.controller;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ypp.util.webUtil;
import com.ypp.entities.User;
import com.ypp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class UserController {
@Resource(name="userService")
  private UserService userService;
    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public boolean add(@RequestBody User user) {
        boolean trueEmail=webUtil.emailFormat(user.getEmail());
        boolean trueMobiel=webUtil.isMobile(user.getMobile());
        boolean truePwd=webUtil.isPwd(user.getPwd());
        //如果密码，邮箱，手机号码格式都正确，则再次查找数据库中是否有这个用户名，就是用户名是否重复
        if(trueEmail||trueMobiel||truePwd){
            if(get(user.getUsername())==null){
                return userService.add(user);
            }
       }
       return false;
        //测试数据
//        User u = new User();
//        u.setAvator("/image/bb.png");
//        u.setEmail("393742195@qq.com");
//        u.setMobile("13681868952");
//        u.setPwd("123456789myc");
//        u.setUsername("bb");
//        userService.add(u);
//        System.out.println(u);
//        return true;
    }
    @RequestMapping(value = "/user/get/{username}", method = RequestMethod.GET)
    public User get(@PathVariable("username") String username) {
        User u= userService.get(username);
        System.out.println(u.toString());
        return  u;
    }
    @RequestMapping(value="/user/findByPage",method=RequestMethod.POST)
    public Page<User> selectList(@PathVariable int pageNum, @PathVariable int pageSize) {
        //startPage(第几页, 每页显示的条数)
       // PageHelper.startPage(pageNum, pageSize);
        return userService.findByPage(pageNum,pageSize);
    }

}
