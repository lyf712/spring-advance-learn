package org.example.ioc;

import org.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration(proxyBeanMethods = false,enforceUniqueMethods = false)
public class IocStartConfig {


    @Bean(value = "person1")
    public Person person(){
        // 配置具体的person
        return new Person();
    }


}
