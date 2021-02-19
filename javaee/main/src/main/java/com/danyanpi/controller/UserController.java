package com.danyanpi.controller;

import com.danyanpi.bean.BaseResponse;
import com.danyanpi.bean.User;
import com.danyanpi.service.serviceImpl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User相关接口")
@RestController
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/api/user/userRegister",method= {RequestMethod.POST})
    public BaseResponse userRegister(@RequestBody User user){
        User user1 = userService.getUserByUsername(user);
        if (user1!=null){
            return new BaseResponse(0, "注册失败,用户名已存在");
        }
        int i = userService.insertUser(user);
        if (i==0){
            return new BaseResponse(0, "注册失败");
        }
        return new BaseResponse(1, "注册成功");
    }
    @RequestMapping(value = "/api/user/userlogin",method= {RequestMethod.POST})//
    public BaseResponse userLogin(@RequestBody User user){
        User user1 = userService.getUserByUsername(user);
        if(user1==null){
            return new BaseResponse(0, "请检查用户名和密码");
        }
        System.out.println(user1.getUsername());
        if (!user1.getPassword().equals(user.getPassword())){
            return new BaseResponse(0, "密码错误");
        }
        return new BaseResponse(1, "登录成功");
    }
}
