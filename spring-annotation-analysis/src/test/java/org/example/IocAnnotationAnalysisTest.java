package org.example;


import org.example.ioc.IocStartConfig;
import org.example.ioc.di.autowire.AutowireConfig;
import org.example.ioc.di.cyclepb.CycleDIConfig;
import org.example.ioc.di.cyclepb.singleton.ComponentA;
import org.example.ioc.di.cyclepb.singleton.ComponentB;
import org.example.ioc.instance.ConfigBean;
import org.example.ioc.instance.PostConstruct;
import org.example.ioc.scope.ScopeBean;
import org.example.ioc.value.ValueConfig;
import org.example.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class IocAnnotationAnalysisTest {

    // 启动策略配置
    private final LoadStrategy loadStrategy = LoadStrategy.SCAN_CLASS;//LoadStrategy.SCAN_PACKAGE;

    private final String scanPackages = "org.example.ioc";
    private final Class clazz = CycleDIConfig.class;//PostConstruct.class;//ScopeBean.class;//AutowireConfig.class;//ValueConfig.class;//LazyConfig.class; //ConditionalConfig.class;//DependsOnConfig.class;
    //PropertySourceAnalysis.class;//ImportAnalysis.class;//BeanAnalysis.class;//ComponentScanAnalysis.class;//IocStartConfig.class;
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

    /**
     * 学习分析IO读取配置文件的设计：
     * 1.classpath
     * 2.绝对路径
     */
    @Test
    public void testPropertySource(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        String name = ctx.getEnvironment().getProperty("name");
        System.out.println(name);
    }

    @Test
    public void tetDependsOn(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;

    }

    @Test
    public void tetConditional(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        final String loacalOsName = ctx.getEnvironment().getProperty("os.name").toLowerCase();
        final String winBean = "win",macBean = "mac";
        Set<String> set = new HashSet<>();
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
              set.add(beanDefinitionName);
        }
        if(loacalOsName.contains("windows")){
            Assert.assertTrue(set.contains(winBean) && !set.contains(macBean));
        }else{
            Assert.assertTrue(set.contains(macBean) && !set.contains(winBean));
        }
    }

    @Test
    public void testLazy_1(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        System.out.println("ioc container start..");
        ctx.close();
        System.out.println("ioc container close..");
    }

    @Test
    public void testLazy_2(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        System.out.println("ioc container start..");
        ctx.getBean("bean2Lady");
        ctx.close();
        System.out.println("ioc container close..");
    }

    @Test
    public void testValue(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        ValueConfig config = (ValueConfig)ctx.getBean("valueConfig");
        //ValueConfig{osName='Windows 10', dbType='mysql', testValue='test', intValue=2, resource=URL [https://www.baidu.com]}
        System.out.println(config);
       // config.getResource().getInputStream(); TODO Resource类~
    }

    @Test
    public void testAutowire(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        //(AutowireConfig)(ctx.getBean("autowireConfig")).toString()
       // System.out.println(((AutowireConfig)ctx.getBean("autowireConfig")).toString());
        System.out.println(ctx.getBean("autowireConfig"));
    }

    /**
     * 对比single,prototype
     */
    @Test
    public void testScope(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        ctx.getBean("singlePerson");
        System.out.println("....");
        ctx.getBean("protoTypePerson");
        ctx.getBean("protoTypePerson");
    }

    @Test
    public void testPostCon() throws InterruptedException {
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        //对于原型bean，容器不管它的生命周期，单例bean则随容器的关闭而~~
        // this.destroyBeans();  this.getBeanFactory().destroySingletons();
        // remove map,对象的~，可结合JVM的对象生命周期一起学习 TODO~ 结合JVM探究Spring的Bean生命周期
        ConfigBean configBean = (ConfigBean) ctx.getBean("configBean");
        //configBean = null;
        TimeUnit.SECONDS.sleep(5);
        System.gc();
        //configBean. 对象如何销毁，结束释放资源
        TimeUnit.SECONDS.sleep(5);
        ctx.close();
        TimeUnit.SECONDS.sleep(5);
    }

    /**
     * 测试单例Bean的setter注入情况（两种）
     */
    @Test
    public void testCycleDI_1(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        // 正常
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName.toString());
        }

        //java.lang.StackOverflowError
        //	at org.example.ioc.di.cyclepb.singleton.ComponentB.toString(ComponentB.java:16)
        // getBean才进行实例化了？？回顾之前的Bean创建过程
        ComponentA componentA = ctx.getBean(ComponentA.class);
        ComponentB componentB = ctx.getBean(ComponentB.class);
        System.out.println(componentA +":" + componentB);
        System.out.println(componentA.getComponentB()+"::"+componentB.getComponentA());
    }


    // org.example.ioc.di.cyclepb.prototype

    @Test
    public void testCycleDI_2(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;

        // Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'componentA' for bean class [org.example.ioc.di.cyclepb.singleton.ComponentA] conflicts with existing, non-compatible
        // bean definition of same name and class [org.example.ioc.di.cyclepb.prototype.ComponentA]
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName.toString());
        }

        //Caused by: org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'componentA' for bean class [org.example.ioc.di.cyclepb.singleton.ComponentA] conflicts with existing,
        // non-compatible bean definition of same name and class [org.example.ioc.di.cyclepb.prototype.ComponentA]
//        org.example.ioc.di.cyclepb.prototype.ComponentA componentA = ctx.getBean(org.example.ioc.di.cyclepb.prototype.ComponentA.class);
//        org.example.ioc.di.cyclepb.prototype.ComponentB componentB = ctx.getBean(org.example.ioc.di.cyclepb.prototype.ComponentB.class);
//        System.out.println(componentA +":" + componentB);
//        System.out.println(componentA.getComponentB()+"::"+componentB.getComponentA());
    }

    @Test
    public void testCycleDI_3(){
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext)context;
        // 正常
//        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName.toString());
//        }

        //java.lang.StackOverflowError
        //	at org.example.ioc.di.cyclepb.singleton.ComponentB.toString(ComponentB.java:16)
        // getBean才进行实例化了？？回顾之前的Bean创建过程
        org.example.ioc.di.cyclepb.proxy.ComponentA componentA = ctx.getBean( org.example.ioc.di.cyclepb.proxy.ComponentA.class);
        org.example.ioc.di.cyclepb.proxy.ComponentB componentB = ctx.getBean( org.example.ioc.di.cyclepb.proxy.ComponentB.class);
        System.out.println(componentA +":" + componentB);
        System.out.println(componentA.getComponentB()+"::"+componentB.getComponentA());
    }


}
