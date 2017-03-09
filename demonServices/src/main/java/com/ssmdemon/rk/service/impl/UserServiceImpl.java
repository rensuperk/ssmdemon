package com.ssmdemon.rk.service.impl;

import com.ssmdemon.rk.common.RespException;
import com.ssmdemon.rk.dao.UserDao;
import com.ssmdemon.rk.model.User;
import com.ssmdemon.rk.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional()
    public void delete(Long id) {

        userDao.deleteByPk(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public User getUser(Long id) {
        return userDao.findByPk(id);
    }
}
