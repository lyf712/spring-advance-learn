package org.example.ioc;

import org.example.model.Person;
import org.springframework.context.annotation.Bean;

/**
 * @author liyunfei
 **/
public class BeanAnalysis {
    /**
     *
     * 1.默认是单例bean;注意单例Bean和多例bean的区别
     * 2.适用于第三方库，例如redisTemplate
     * 3.
     *
     * */
    @Bean(value = "person1",initMethod = "init",destroyMethod = "destory")
    Person person(){
        return new Person();
    }
}
