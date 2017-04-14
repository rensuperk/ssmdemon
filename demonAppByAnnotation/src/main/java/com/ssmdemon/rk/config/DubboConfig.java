package com.ssmdemon.rk.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by renkai on 2017/3/16.
 */
@Configuration
public class DubboConfig{

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.ssmdemon.rk.service");
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
    RegistryConfig registryconfig(){
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://192.168.56.102:2181");
        registryConfig.setCheck(true);
        return registryConfig;
    }
    @Bean
    ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        return  protocolConfig;
    }

}

