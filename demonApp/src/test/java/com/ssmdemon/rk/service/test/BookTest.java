package com.ssmdemon.rk.service.test;

import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.action.BookAction;
import com.ssmdemon.rk.common.RespDto;
import com.ssmdemon.rk.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by renkai on 2017/3/9.
 */
public class BookTest extends BaseTest{
    @Autowired
    private BookAction bookAction;

    @Test
    public void testSave(){
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setName("书"+i);
            book.setPrice(Double.valueOf(String.valueOf(i)));
            RespDto re = bookAction.save(book);
            System.out.println(JSON.toJSONString(re));
        }
    }
    @Test
    public void testlist(){
        Book book = new Book();
//        book.setName("名字1");
        Integer offset =0;
        Integer limit = 10;
        RespDto re = bookAction.list(book,offset, limit);
        System.out.println(JSON.toJSONString(re));
    }
    @Test
    public void testget(){
        Long id = 1l;
        RespDto re = bookAction.get( id);
        System.out.println(JSON.toJSONString(re));

    }
    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setName("名字1");
        book.setId(1l);
        RespDto re = bookAction.Update( book);
        System.out.println(JSON.toJSONString(re));
    }
    @Test
    public void testDelete(){
        Long id = 1l;
        RespDto re = bookAction.delete( id);
        System.out.println(JSON.toJSONString(re));
    }

}
