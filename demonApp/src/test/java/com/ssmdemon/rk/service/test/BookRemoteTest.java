package com.ssmdemon.rk.service.test;

import com.alibaba.fastjson.JSON;
import com.ssmdemon.rk.action.BookAction;
import com.ssmdemon.rk.common.RespDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by renkai on 2017/3/10.
 */
@ContextConfiguration({ "classpath:spring/spring-dubbo.xml" })
public class BookRemoteTest extends BaseTest{


    @Autowired
    private BookAction bookAction;
    @Test
    public void testsaveBookRecoud(){
        Long id = 1l;
        RespDto re = bookAction.listByUserId(id,0,10);
        System.out.println(JSON.toJSONString(re));
    }
}