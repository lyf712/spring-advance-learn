package org.example.ioc.di.cyclepb.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ComponentB {
    @Autowired
    ComponentA componentA;

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
