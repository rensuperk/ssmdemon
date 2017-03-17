package com.ssmdemon.rk.config;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by renkai on 2017/3/16.
 */
public class Startup extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                RootConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                SpringMVCConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
