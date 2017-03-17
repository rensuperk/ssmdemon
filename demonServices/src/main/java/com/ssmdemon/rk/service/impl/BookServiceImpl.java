package com.ssmdemon.rk.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.dao.BookDao;
import com.ssmdemon.rk.model.Book;
import com.ssmdemon.rk.service.BookRemoteService;
import com.ssmdemon.rk.service.BookService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by renkai on 2017/3/9.
 */
@Service
public class BookServiceImpl implements BookService{

    @Reference(check = true)
    private BookRemoteService bookRemoteService;
    @Autowired
    private BookDao bookDao;
    @Autowired(required = false)
    private KafkaTemplate<Integer,String> kafkaTemplate;

    @Transactional
    public void save(Book book) {
        kafkaTemplate.sendDefault(JSON.toJSONString(book));
//        bookDao.save(book);
    }

    public List<Book> list(Book book, Integer offset, Integer limit) {
        List<Book> list = bookDao.list(book, new RowBounds(offset, limit));
        return list;
    }

    public Long count(Book book) {
         Long count = bookDao.count(book);
        return count;
    }

    public Book get(Long id) {
        Book book = bookDao.findByPk(id);
        return book;
    }
    @Transactional
    public void update(Book book) {
        bookDao.update(book);
    }
    @Transactional
    public void delete(Long id) {
        bookDao.deleteByPk(id);
    }

//    public Page<Book> getList(Long id, Integer offset, Integer limit) {
//        List<Book> books = bookRemoteService.listByUserId(id, offset, limit);
//        Integer integer = bookRemoteService.countByUserId(id);
//        PageImpl<Book> books1 = new PageImpl<Book>(books,new PageRequest(offset,limit),integer);
//
//        return books1;
//    }
}
