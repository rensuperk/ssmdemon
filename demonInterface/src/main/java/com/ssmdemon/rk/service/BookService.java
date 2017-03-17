package com.ssmdemon.rk.service;

import com.ssmdemon.rk.model.Book;

import java.util.List;

/**
 * Created by renkai on 2017/3/9.
 */
public interface BookService {
    void save(Book book);

    List<Book> list(Book book, Integer offset, Integer limit);

    Long count(Book book);

    Book get(Long id);

    void update(Book book);

    void delete(Long id);
//    Page<Book> getList(Long id, Integer offset, Integer limit);
}
