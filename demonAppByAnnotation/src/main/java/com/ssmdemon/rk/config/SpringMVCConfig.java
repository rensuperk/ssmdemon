package com.ssmdemon.rk.config;

import com.ssmdemon.rk.common.exception.GlobleException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by renkai on 2017/3/16.
 */
/*<aop:aspectj-autoproxy proxy-target-class="true" />*/
@EnableAspectJAutoProxy(proxyTargetClass=true)
//<mvc:annotation-driven />
@EnableWebMvc
@ComponentScan(basePackages = "com.ssmdemon.rk.action")
public class SpringMVCConfig  extends WebMvcConfigurationSupport {
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
