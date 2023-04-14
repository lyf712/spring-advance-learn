package org.example;


import org.example.ioc.IocStartConfig;
import org.example.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liyunfei
 **/
public class IocAnnotationAnalysisTest {

    // 启动策略配置
    private final LoadStrategy loadStrategy = LoadStrategy.SCAN_PACKAGE;

    private final String scanPackages = "org.example.ioc";
    private final Class clazz = IocStartConfig.class;
    private ApplicationContext context;

    enum LoadStrategy{
         SCAN_PACKAGE,
         SCAN_CLASS
    }

    @Before
    public void initIOC(){
           // 通过class加载，则无需注解配置；
           // 通过包扫描则需要配置@Config..注解
           // 见AnnotationConfigApplicationContext的register和scan,refresh的过程！
           switch (loadStrategy){
               case SCAN_CLASS:context = new AnnotationConfigApplicationContext(clazz);break;
               case SCAN_PACKAGE:context = new AnnotationConfigApplicationContext(scanPackages);break;
           }
    }

    /**
     * 1.测试两种不同方式创建IOC容器（注解可省略
     * 2.测试注解的proxyMe--单例与否
     * 3.
     */
    @Test
    public void testConfiguration(){
          // 修改策略：No qualifying bean of type 'org.example.ioc.IocStartConfig' available
          IocStartConfig config = context.getBean(IocStartConfig.class);
          Person person1 = config.person();
          Person person2 = config.person();
          // 调整proxyMethod,看是否为单例（full模式，或者lite轻量级模式）默认是true，单例
          System.out.println(person1==person2);
    }

    /**
     * 关键源码分析：
     * 1.注册
     * 2.实例化
     * 调试：AnnotationConfigApplicationContext ；画时序图理解！！
     */
    @Test
    public void testConfigurationRegisterAndIntance(){
//    public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
//            this();
//            this.register(componentClasses);
//            this.refresh();
//        }
//
//    public AnnotationConfigApplicationContext(String... basePackages) {
//            this();
//            this.scan(basePackages);
//            this.refresh();
//        }
    }

}