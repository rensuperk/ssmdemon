package com.ssmdemon.rk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by renkai on 2017/3/16.
 */

@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages = {"com.ssmdemon.rk"})
@PropertySource("classpath:bootstrapt.properties")
public class RootConfig{
}
