package com.ssmdemon.rk.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by renkai on 2017/3/16.
 */
@Configuration
@MapperScan(value = "com.ssmdemon.rk.dao",sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class DaoConfig {

    @Autowired
    protected  Environment environment;



    @Bean(name = "dataSource",initMethod = "init",destroyMethod = "close")
    DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("jdbc_url"));
        druidDataSource.setUsername(environment.getProperty("jdbc_username"));
        druidDataSource.setPassword(environment.getProperty("jdbc_password"));
        druidDataSource.setInitialSize(0);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxIdle(20);
        druidDataSource.setMinIdle(0);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(25200000);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(1800);
        druidDataSource.setLogAbandoned(true);
        try {
            druidDataSource.setFilters("mergeStat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        Properties properties = new Properties();
        properties.put("useGeneratedKeys",true);
        properties.put("useColumnLabel",true);
        properties.put("mapUnderscoreToCamelCase",true);
        sqlSessionFactoryBean.setConfigurationProperties(properties);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ssmdemon.rk.model");
        return sqlSessionFactoryBean;
    }

}
