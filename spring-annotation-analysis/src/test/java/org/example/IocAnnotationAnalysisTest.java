package org.example;


import org.example.ioc.BeanAnalysis;
import org.example.ioc.ComponentScanAnalysis;
import org.example.ioc.IocStartConfig;
import org.example.ioc.imports.ImportAnalysis;
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
    private final LoadStrategy loadStrategy = LoadStrategy.SCAN_CLASS;//LoadStrategy.SCAN_PACKAGE;

    private final String scanPackages = "org.example.ioc";
    private final Class clazz = ImportAnalysis.class;//BeanAnalysis.class;//ComponentScanAnalysis.class;//IocStartConfig.class;
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

    @Test
    public void testComponentScan(){
        // 对于内置的后置器是无法-
        /**
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         */
        String[]beans = context.getBeanDefinitionNames();
        for(String bean:beans){
            System.out.println(bean);
        }
    }

    /**
     * <p>理解单例Bean和多例bean的区别</p>
     * <p>在注册过程中，init和destroy方法是如何去处理的加工</p>
     *
     */
    @Test
    public void testBean(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;

        Person person1 = ctx.getBean(Person.class);
        Person person2 = ctx.getBean(Person.class);
        System.out.println(person1==person2);
        // ctx.close();

        //((AnnotationConfigApplicationContext) context).registerBean();
    }

    /**
     * @Desc:测试@import注解的三种使用方式
     */
    @Test
    public void testImportBean(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }



}
