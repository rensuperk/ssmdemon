package com.ssmdemon.rk.service;

import com.ssmdemon.rk.model.Book;

import java.util.List;

/**
 * Created by renkai on 2017/3/10.
 */
public interface BookRemoteService {
    List<Book> listByUserId(Long id, Integer offset, Integer limit);

    Integer countByUserId(Long id);
}
