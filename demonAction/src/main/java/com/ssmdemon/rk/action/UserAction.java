package com.ssmdemon.rk.action;


import com.ssmdemon.rk.common.RespDto;
import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserAction{

    @Autowired
    private UserService userService;


    @RequestMapping(value = "list")
    public @ResponseBody
    RespDto list(User user, @RequestParam(defaultValue = "0") Integer start, @RequestParam(defaultValue = "10") Integer limit){
        List<User> list = userService.list(user, 0, 10);

        return new RespDto().put("rows",list);
    }
@RequestMapping(value = "{id}")
    public @ResponseBody
    RespDto get(@PathVariable(value = "id") Long id){
        User user = userService.getUser(id);

    return new RespDto().put("obj",user);
    }
@RequestMapping(value = "delete/{id}")
    public @ResponseBody
    RespDto delete(@PathVariable(value = "id") Long id){
        userService.delete(id);

        return new RespDto();
    }
@RequestMapping(value = "update")
    public @ResponseBody
    RespDto update( User user){
    userService.update(user);
        return new RespDto();
    }
@RequestMapping(value = "save")
    public @ResponseBody
    RespDto save(@Valid() User user){
        userService.save(user);
    return new RespDto();
    }

}