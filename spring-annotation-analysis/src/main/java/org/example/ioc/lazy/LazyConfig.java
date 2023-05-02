package org.example.ioc.lazy;

import org.springframework.context.annotation.*;

/**
 * @author liyunfei
 **/
@Configuration
// @ComponentScan(basePackages = "org.example.ioc.lazy")
public class LazyConfig {
    @Bean
    public String bean1(){
        System.out.println("init bean1");
        return "bean1";}
    // 启动时不创建，延迟创建；优化启动；只针对单例bean起效
    @Lazy
    @Bean
    //@Scope
    public String bean2Lady(){System.out.println("init bean2Lady");return "bean2Lady";}
}
