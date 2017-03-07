package com.ssmdemon.rk.action;


import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserAction{

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/")
    public @ResponseBody
    List<User> hello(){

        List<User> list = userService.list(new User(), 0, 10);
        return list;
    }

}