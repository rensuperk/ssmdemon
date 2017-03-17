package com.ssmdemon.rk.config;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.support.AbstractRegistry;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renkai on 2017/3/16.
 */
@Configuration
public class DubboConfig {
    @Bean
    public static AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.ssmdemon.rk");
        return annotationBean;
    }
    @Bean
    public ApplicationConfig applicationConfig() {
        // 当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("ssmdemon");
        return applicationConfig;
    }
    @Bean
    Registry registry(){
        Registry registry = new AbstractRegistry(URL.valueOf("zookeeper://192.168.10.20:2181")) {
            public boolean isAvailable() {
                return true;
            }
        };
        return registry;
    }
    @Bean
    Protocol protocol(){
        return new DubboProtocol();
    }

}

