package com.ssmdemon.rk.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by renkai on 2017/3/14.
 */
public class KafkaTest extends BaseTest{

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
    /**
     * 向kafka里写数据.<br/>
     * @author miaohongbin
     * Date:2016年6月24日下午6:22:58
     */
    @Test
    public void testTemplateSend(){
//        kafkaTemplate.send("test","haha111");
        kafkaTemplate.sendDefault("aaaa");
    }

}
