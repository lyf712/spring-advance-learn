package org.example.transaction.sample.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author liyunfei
 **/
@Configuration
@ComponentScan("org.example.transaction.sample")
@PropertySource("classpath:druid.properties")
// 为何出现 dataSource找不到 ,require dataSource,然后又突发性好了？？？
// 思考对比 @Import,@Bean,接口\class,@Configuration
@Import({DataSourceConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class TransactionConfig {

    @Bean
    TransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
