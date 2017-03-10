package com.ssmdemon.rk.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ssmdemon.rk.common.RespDto;
import com.ssmdemon.rk.model.Book;
import com.ssmdemon.rk.service.BookRemoteService;
import com.ssmdemon.rk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by renkai on 2017/3/9.
 */
@Controller
@RequestMapping("/book")
public class BookAction {
    @Autowired
    private BookService bookService;

    @Reference
    private BookRemoteService bookRemoteService;

    @ResponseBody
    @RequestMapping("save")
    public RespDto save(Book book) {
        bookService.save(book);
        return new RespDto();
    }
    @RequestMapping("list")
    @ResponseBody
    public RespDto list(Book book, @RequestParam(defaultValue = "0") Integer offset,@RequestParam(defaultValue = "10") Integer limit) {
        List<Book> list = bookService.list(book,offset,limit);
        Long count = bookService.count(book);
        return new RespDto().put("rows",list).put("count",count);
    }
    @RequestMapping("{id}")
    @ResponseBody
    public RespDto get(@PathVariable(value = "id") Long id) {
        Book book  = bookService.get(id);
        return new RespDto().put("obj",book);
    }

    @RequestMapping("update")
    @ResponseBody
    public RespDto Update(Book book) {
        bookService.update(book);
        return new RespDto();
    }
    @RequestMapping("delete/{id}")
    @ResponseBody
    public RespDto delete( @PathVariable(value = "id") Long id) {

        bookService.delete(id);
        return new RespDto();
    }
    @RequestMapping("borrowedBy/{id}")
    @ResponseBody
    public RespDto listByUserId(@PathVariable("id") Long id, @RequestParam(defaultValue = "0") Integer offset,@RequestParam(defaultValue = "10") Integer limit) {
        List<Book> list = bookRemoteService.listByUserId(id,offset,limit);
        Integer count = bookRemoteService.countByUserId(id);
        return new RespDto().put("rows",list).put("count",count);
    }
}
