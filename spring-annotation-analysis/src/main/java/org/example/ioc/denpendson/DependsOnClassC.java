package org.example.ioc.denpendson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration(value = "DependsOnClassC")
public class DependsOnClassC {
//    static {
//        System.out.println("DependsOnClassC init~");
//    }
    // TODO 理解类信息加载至内存区和初始化（实例化）的顺序
    public DependsOnClassC(){
        System.out.println("DependsOnClassC init~");
    }
    @Bean("BeanA")
    public void methodA(){
        System.out.println("init BeanA");
    }
    @Bean("BeanB")
    public void methodB(){
        System.out.println("init BeanB");
    }
}
