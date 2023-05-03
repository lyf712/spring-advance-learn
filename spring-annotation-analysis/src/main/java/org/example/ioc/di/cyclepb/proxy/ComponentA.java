package org.example.ioc.di.cyclepb.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ComponentA {
    @Autowired
    ComponentB componentB;

    @Async
    public ComponentB getComponentB() {
        return componentB;
    }

    //    @Override
//    public String toString() {
//        return "ComponentA{" +
//                "componentB=" + componentB +
//                '}';
//    }
}
