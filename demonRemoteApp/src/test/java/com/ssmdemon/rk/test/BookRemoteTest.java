package com.ssmdemon.rk.test;

import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.model.Book;
import com.ssmdemon.rk.service.BookRemoteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by renkai on 2017/3/10.
 */
//@ContextConfiguration({ "classpath:spring/spring-dubbo.xml" })
public class BookRemoteTest extends BaseTest{
    @Autowired
    private BookRemoteService bookRemoteService;

    @Test
    public void testsaveBookRecoud(){
        Long id = 1l;
        List<Book> books = bookRemoteService.listByUserId(id, 0, 10);
        System.out.println(JSON.toJSONString(books));
    }
}
