package org.example.transaction.sample.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liyunfei
 **/
public class MybatisConfig {

    private final static String BASE_PACKAGE = "org.example.transaction.sample.dao";
    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){//DataSource dataSource
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(BASE_PACKAGE);
        return sqlSessionFactoryBean;
    }

    @Bean
    MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE);
        return mapperScannerConfigurer;
    }

}
