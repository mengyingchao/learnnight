package com.ypp.springcloud.controller;
import com.ypp.springcloud.util.FileUtil;
import com.ypp.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FileUploadController {

    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "file";
    }
    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public User uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("pwd") String pwd, @RequestParam("email") String email, @RequestParam("mobile") String mobile, @RequestParam("username") String username, HttpServletRequest request) {
        User u = new User();
        u.setPwd(pwd);
        u.setMobile(mobile);
        u.setEmail(email);
        u.setUsername(username);
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if(filePath!=null&&filePath!=""){
            u.setAvator(filePath);
            HttpSession session=request.getSession();
            session.setAttribute("user",u);
            return u;
        }
        //返回json
        return null;
    }

    }
