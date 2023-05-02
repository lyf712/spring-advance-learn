package org.example.ioc.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author liyunfei
 **/
@Configuration
public class ConfigBean {
    @Value("")
    String name;
//    final Integer age;
//
//    public ConfigBean(Integer age) {
//        //Environment environment =
//        this.age = age;
//    }

}
