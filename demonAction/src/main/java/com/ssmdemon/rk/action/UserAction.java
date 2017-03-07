package com.ssmdemon.rk.action;


import com.ssmdemon.rk.exception.RespException;
import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserAction{

    @Autowired
    private UserService userService;


    @RequestMapping(value = "")
    public @ResponseBody
    List<User> hello(){
        User user = null;
        if(user ==null){
            throw new RespException("你说啥");
        }
        List<User> list = userService.list(new User(), 0, 10);
        return list;
    }

}