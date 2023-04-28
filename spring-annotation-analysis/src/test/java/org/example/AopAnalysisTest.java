package org.example;

import org.example.aop.AopSysConfig;
import org.example.aop.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

/**
 * @author liyunfei
 **/
public class AopAnalysisTest {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopSysConfig.class);

    /**
     * spring-aop包含：@EnableAspectAutoProxy;测试aop相关的基础注解使用
     *
     * 1.AspectJ 和 AOP 的关系
     *
     */
    @Test
    public void testBaseAnnotationUse(){
                // 分析到pointcut表达式出错、pjd的返回值为空、等情况应该如何处理的
                DemoService service = context.getBean(DemoService.class);
                boolean rs = service.login(Collections.emptyMap());
                Assert.assertTrue(rs);
    }

    /**
     * @TCDescription: @EnableAspectJAutoProxy的exposeProxy开启则暴露代理对象给aopContext
     * @TestStep:
     * @ExpectResult:
     */
    @Test
    public void testAopContextAcquireProxy(){

    }

}
