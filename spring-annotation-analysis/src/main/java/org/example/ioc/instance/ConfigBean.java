package org.example.ioc.instance;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ConfigBean {
    static {
        System.out.println("<clinit>...");
    }
    public ConfigBean() {
        System.out.println("<init> ...");
    }
    //@PostConstruct
    void preInit(){
        System.out.println("pre init..");
    }
    void init(){
        System.out.println("init...");
    }

    @PreDestroy
    void preDestroy(){
        System.out.println("pre destroy");
    }
    void destroy(){
        System.out.println("destroy...");
    }

    @Override
    protected void finalize() throws Throwable {
        // 重写~
        System.out.println("finalize...");
        super.finalize();
    }
}
