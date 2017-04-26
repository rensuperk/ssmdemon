package com.ssmdemon.rk.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by renkai on 2017/3/16.
 */
@Configuration
@Conditional(DubboCondition.class)
public class DubboConfig implements EnvironmentAware{

    protected  String zkAddress;
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
        RegistryConfig registryConfig = new RegistryConfig(zkAddress);
        registryConfig.setCheck(true);
        return registryConfig;
    }
    @Bean
    ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        return  protocolConfig;
    }

    public void setEnvironment(Environment environment) {
         zkAddress = environment.getProperty("zk_address");
    }
}

