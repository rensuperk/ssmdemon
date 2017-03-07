package com.ssmdemon.rk.dao;

import com.ssmdemon.rk.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by root on 17-3-6.
 */
public interface UserDao{
    List<User> list(User user, RowBounds rowBounds);
    void delete(Long id);
    void update(User user);
    void save(User user);
    User getUser(Long id);

}
