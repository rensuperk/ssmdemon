package com.ssmdemon.rk.service;

import com.ssmdemon.rk.model.User;

import java.util.List;

public interface UserService{
    List<User> list(User user,Integer start,Integer limit);
    void delete(Long id);
    void update(User user);
    void save(User user);
    User getUser(Long id);

}
