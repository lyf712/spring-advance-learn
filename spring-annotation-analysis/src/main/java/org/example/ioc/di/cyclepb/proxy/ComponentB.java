package org.example.ioc.di.cyclepb.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ComponentB {
    @Autowired
    ComponentA componentA;

    @Async
    public ComponentA getComponentA() {
        return componentA;
    }

    //    @Override
//    public String toString() {
//        return "ComponentB{" +
//                "componentA=" + componentA +
//                '}';
//    }
}
