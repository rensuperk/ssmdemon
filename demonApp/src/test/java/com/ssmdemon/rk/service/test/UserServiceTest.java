package com.ssmdemon.rk.service.test;

import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;



public class UserServiceTest extends BaseTest{
   @Autowired
   private UserService userService;
    @Test
    public void testlist(){
        User user = new User();
        user.setName("aaa");
        List<User> list = userService.list(user, 0, 10);
        System.out.println(JSON.toJSONString(list));
    }
    @Test
    public void testget(){
        User user = userService.getUser(1l);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testdelete(){
        userService.delete(1l);
    }


    @Test
    public void testsave(){
        User user = new User("c", new Date(), "aaa", 1);
        userService.save(user);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void testupdate(){
        User user = new User(2l,"c", new Date(), "aaa", 1);
        userService.update(user);
        System.out.println(JSON.toJSONString(user));
    }

}
