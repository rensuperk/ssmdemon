package com.ssmdemon.rk.service.test;

import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by renkai on 2017/3/6.
 */

public class UserServiceTest extends BaseTest{
   @Autowired
   private UserService userService;
    @Test
    public void testlist(){
        User user = new User();
        user.setName("aaa");
        List<User> list = userService.list(user, 0, 10);
        System.out.println(list.size());
    }

}
