package org.example.ioc;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Configuration(value = "Config1")
public class ConfigurationAnalysis {
    // 相对于id，唯一标识bean
//    @AliasFor(
//            annotation = Component.class
//    )
//    String value() default "";
//    @bean的创建方式，true则单例--
//    boolean proxyBeanMethods() default true;
//    @Bean的方法名词唯一？
//    boolean enforceUniqueMethods() default true;

}
