package org.example.ioc.di.cyclepb.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class ComponentA {
    @Autowired
    ComponentB componentB;

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
