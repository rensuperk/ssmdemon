package com.ssmdemon.rk.service.impl;

import com.ssmdemon.rk.dao.UserDao;
import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renkai on 2017/3/6.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> list(User user, Integer start, Integer limit) {

        return userDao.list(user,new RowBounds(start,limit));
    }

    public void delete(Long id) {

    }

    public void update(User user) {

    }

    public void save(User user) {

    }

    public User getUser(Long id) {
        return null;
    }
}
