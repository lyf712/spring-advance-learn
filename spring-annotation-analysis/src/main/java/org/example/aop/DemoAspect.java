package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author liyunfei
 **/
@EnableAspectJAutoProxy(exposeProxy = true)
@Component
@Aspect
public class DemoAspect {

    private static final String SERVICE_ADD_POINTCUT = "execution(* org.example.aop.DemoService.login(..))";

//    @Around(SERVICE_ADD_POINTCUT)
//    Object pointCutServiceAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//         System.out.println(new Date() + "before log");
//         Object retVal = proceedingJoinPoint.proceed();
//         System.out.println(new Date() + "after log");
//         return retVal;
//    }

    @Before(SERVICE_ADD_POINTCUT)
    public void before(){
        System.out.println("before log");
        //java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available, and ensure that AopContext.currentProxy()
        // is invoked in the same thread as the AOP invocation context.
//        System.out.println(AopContext.currentProxy() instanceof DemoService);
//        System.out.println(AopContext.currentProxy() instanceof HelloService);
    }

    @After(SERVICE_ADD_POINTCUT)
    public void after(){
        System.out.println("after log");
    }

    @AfterReturning(SERVICE_ADD_POINTCUT)
    public void afterReturning(){

    }

    @AfterThrowing(SERVICE_ADD_POINTCUT)
    public void afterThrowing(){

    }

}
