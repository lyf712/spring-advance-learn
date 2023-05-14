package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.transaction.sample.config.TransactionConfig;
import org.example.transaction.sample.entity.User;
import org.example.transaction.sample.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author liyunfei
 **/
public class TransactionAnalysisTest {
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;
    @Before
    public void setUp(){
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
    }
    @Test
    public void testBaseTransaction(){
        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        User user = new User("lyf712",12);
        userService.register(user);
    }
}
