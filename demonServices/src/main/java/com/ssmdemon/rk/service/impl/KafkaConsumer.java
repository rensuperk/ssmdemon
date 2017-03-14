package com.ssmdemon.rk.service.impl;

import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.dao.BookDao;
import com.ssmdemon.rk.model.Book;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListener;

/**
 * Created by renkai on 2017/3/14.
 */
public class KafkaConsumer  implements MessageListener<Integer,String>{

    @Autowired
    private BookDao bookDao;
    public void onMessage(ConsumerRecord<Integer, String> record) {
        System.out.println(record);
        Book book = JSON.parseObject(record.value(), Book.class);
        bookDao.save(book);
    }
}
