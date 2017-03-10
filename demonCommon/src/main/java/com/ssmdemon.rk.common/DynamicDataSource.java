package com.ssmdemon.rk.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * Created by renkai on 2017/3/10.
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    public static final String DATA_SOURCE_C3P0 = "dataSourceC3p0";
    public static final String DATA_SOURCE_DRUID = "dataSourceDruid";
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static String  getContextHolder() {
        return contextHolder.get();
    }

    public static  void setContextHolder(String customerType) {
        contextHolder.set(customerType);  ;
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
    protected Object determineCurrentLookupKey() {
        return getContextHolder();
    }
}
