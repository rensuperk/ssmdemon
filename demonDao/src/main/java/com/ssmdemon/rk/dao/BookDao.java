package com.ssmdemon.rk.dao;

import com.ssmdemon.rk.model.Book;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by renkai on 2017/3/8.
 */
public interface BookDao {
    List<Book> list(Book user, RowBounds rowBounds);
    void deleteByPk(Long id);
    void update(Book user);
    void save(Book user);
    Book findByPk(Long id);
    List<Book> listByUserId(Long id,RowBounds rowBounds);

    Long count(Book book);

    Integer countByUserId(Long id);
}
