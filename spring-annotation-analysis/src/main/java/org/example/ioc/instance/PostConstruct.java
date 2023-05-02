package org.example.ioc.instance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author liyunfei
 **/
@Configuration
@ComponentScan
public class PostConstruct {
       @Scope("prototype")
       @Bean(initMethod = "init",destroyMethod = "destroy")
       ConfigBean configBean(){
           return new ConfigBean();
       }
}
