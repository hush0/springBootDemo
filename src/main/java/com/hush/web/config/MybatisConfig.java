package com.hush.web.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: huangshuai
 * @Date: 2020-07-29
 * @Version 1.0
 */
@Slf4j
@Configuration
@MapperScan(basePackages="com.hush.web.mybatis.mapper")
public class MybatisConfig {

    @Autowired
    private Environment env;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(env.getProperty("mybatis.mapper-locations")));
        log.info("sqlSessionFactory:--->mybatis.mapperLocation:" + env.getProperty("mybatis.mapper-locations"));

        sqlSessionFactoryBean.setDataSource(getDataSource());
        org.apache.ibatis.session.Configuration cfg = new org.apache.ibatis.session.Configuration();
        Integer timeOut = Integer.parseInt(env.getProperty("mybatis.default-statement-timeout"));
        cfg.setDefaultStatementTimeout(timeOut);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{getPageInterceptor()});
        log.info("sqlSessionFactoryBean:-->" + sqlSessionFactoryBean.getObject());
        log.info("default-statement-timeout:" + timeOut);
        sqlSessionFactoryBean.setConfiguration(cfg);
        return sqlSessionFactoryBean.getObject();
    }

    public PageInterceptor getPageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("pageSizeZero", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    public DataSource getDataSource() {
        Properties props = new Properties();
        props.put("driverClass", env.getProperty("spring.datasource.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.url"));
        props.put("username", env.getProperty("spring.datasource.username"));
        props.put("password", env.getProperty("spring.datasource.password"));
        try {
            return DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
