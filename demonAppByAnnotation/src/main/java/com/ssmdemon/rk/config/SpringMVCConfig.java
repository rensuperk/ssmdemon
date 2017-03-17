package com.ssmdemon.rk.config;

import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.ssmdemon.rk.common.exception.GlobleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by renkai on 2017/3/16.
 */
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@ComponentScan(basePackages = {"com.ssmdemon.rk"})
//<mvc:annotation-driven />
@EnableWebMvc
public class SpringMVCConfig  extends WebMvcConfigurationSupport {


    @Bean
    public AnnotationBean annotationBean2() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage("com.ssmdemon.rk.action");
        return annotationBean;
    }
    @Bean
    public InternalResourceViewResolver viewResolver(){

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //    <mvc:default-servlet-handler/>
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("default");
    }
    @Bean
    public GlobleException globleException(){
        return new GlobleException();
    }
}
