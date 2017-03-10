package com.ssmdemon.rk.service.impl;

import com.ssmdemon.rk.dao.BookDao;
import com.ssmdemon.rk.model.Book;
import com.ssmdemon.rk.model.BookRecoud;
import com.ssmdemon.rk.service.BookRemoteService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by renkai on 2017/3/10.
 */
@com.alibaba.dubbo.config.annotation.Service
public class BookRemoteServiceImpl implements BookRemoteService{


    @Autowired
    private BookDao bookDao;

    public List<Book> listByUserId(Long id, Integer offset, Integer limit) {
        return bookDao.listByUserId(id,new RowBounds(offset,limit));
    }

    public Integer countByUserId(Long id) {
        return bookDao.countByUserId(id);
    }

    public void borrowBook(BookRecoud bookRecoud) {
        bookDao.borrowBook(bookRecoud);
    }

    public void backBook(BookRecoud bookRecoud) {
        bookDao.backBook(bookRecoud);
    }
}
