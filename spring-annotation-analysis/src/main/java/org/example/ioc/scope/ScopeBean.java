package org.example.ioc.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ScopeBean {
    /**
     *     @AliasFor("scopeName")
     *     String value() default "";
     *     --时机阶段：IOC启动，用户调用，用户请求的阶段（request，session，application）
     *     1.singleton:单例bean,结合lazy : 可能存在多线程的不安全问题（非静态属性）-- 存在共享访问操作的情况
     *     2.prototype:原型bean，创建IOC容器不创建，使用一个bean则创建一个bean
     *
     *     @AliasFor("value")
     *     String scopeName() default "";
     *
     *     ScopedProxyMode proxyMode() default ScopedProxyMode.DEFAULT;*
     */
    class Person{
        static {
            System.out.println("<clinit> person class info...");
        }

        public Person() {
            System.out.println("<init> instance");
        }
    }

    @Bean
    @Scope(value = "singleton")
    Person singlePerson(){return new Person();}

    @Bean
    @Lazy
    @Scope(value = "singleton")
    Person singleLazyPerson(){return new Person();}

    @Bean
    @Scope(value = "prototype")
    Person protoTypePerson(){return new Person();}

    @Bean
    @Scope(value = "request",proxyMode = ScopedProxyMode.DEFAULT)
    Person requestPerson(){return new Person();}
    // session,application~~
}
