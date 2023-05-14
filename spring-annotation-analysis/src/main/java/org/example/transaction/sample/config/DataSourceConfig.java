package org.example.transaction.sample.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.proxy.DruidDriver;
import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

/**
 * @author liyunfei
 **/

public class DataSourceConfig {
    @Value("${druid.jdbcUrl}")
    private String jdbcUrl;
    @Value("${druid.username}")
    private String username;
    @Value("${druid.password}")
    private String password;

    @Value("${druid.init}")
    private Integer init;
    @Value("${druid.minIdle}")
    private Integer minIdle;
    @Value("${druid.maxActive}")
    private Integer maxActive;
    @Value("${druid.maxWait}")
    private Integer maxWait;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        // base info
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        // driver,source,jdbc直接的关系？，连接池,druid，mybatis,jpa,hibernate
        // new DruidDriver()
        //FIXME 采用Druid的驱动则会出问题，debug一下
        druidDataSource.setDriver(new Driver()); // new Driver() //new DruidDriver()

        // 附加信息
        druidDataSource.setInitialSize(init);
        druidDataSource.setMinIdle(minIdle);
        //
        druidDataSource.setMaxActive(maxActive);
        //DbType.
        //druidDataSource.setDbType(DbType.mysql);
        druidDataSource.setMaxWait(maxWait);

        return druidDataSource;
    }
}
