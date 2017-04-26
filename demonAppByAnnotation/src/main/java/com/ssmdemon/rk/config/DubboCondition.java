package com.ssmdemon.rk.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by renkai on 2017/4/26.
 */
public class DubboCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Boolean.parseBoolean(context.getEnvironment().getProperty("dubbo.open", "true"));
    }
}
