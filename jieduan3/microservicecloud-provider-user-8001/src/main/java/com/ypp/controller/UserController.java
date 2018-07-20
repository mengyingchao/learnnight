package com.ypp.controller;
import com.github.pagehelper.Page;
import com.ypp.entities.User;
import com.ypp.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.ypp.util.webUtil;
import javax.annotation.Resource;

@RestController
public class UserController {
@Resource(name="userService")
  private UserService userService;
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public boolean add(@RequestBody User user) {
        boolean trueEmail=webUtil.emailFormat(user.getEmail());
        boolean trueMobiel=webUtil.isMobile(user.getMobile());
        boolean truePwd=webUtil.isPwd(user.getPwd());
        //如果密码，邮箱，手机号码格式都正确，则再次查找数据库中是否有这个用户名，就是用户名是否重复
        if(trueEmail||trueMobiel||truePwd){
            if(get(user.getUsername())==null){//测数据库是否有这个用户
                return userService.add(user);
            }
       }
       return false;
    }
    @RequestMapping(value = "/user/get/{username}", method = RequestMethod.GET)
    public User get(@PathVariable("username") String username) {
        User u= userService.get(username);
        System.out.println(u.toString());
        return  u;
    }
    @RequestMapping(value="/user/findByPage/{pageNum}/{pageSize}",method=RequestMethod.GET)
    public Page<User> selectList(@PathVariable int pageNum, @PathVariable int pageSize) {
        //startPage(第几页, 每页显示的条数)
       // PageHelper.startPage(pageNum, pageSize);
        return userService.findByPage(pageNum,pageSize);
    }

}
