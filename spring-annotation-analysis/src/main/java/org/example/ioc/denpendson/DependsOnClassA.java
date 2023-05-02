package org.example.ioc.denpendson;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component("DependsOnClassA")
// 只会让该注解提前，但其中的method的bean任然保持~
//@DependsOn(value = {"DependsOnClassC"})
@DependsOn(value = {"DependsOnClassB"})
public class DependsOnClassA extends AbstractDepensOnClass{
//    static {
//        System.out.println("init ");
//    }
    public DependsOnClassA(){init();}
}
