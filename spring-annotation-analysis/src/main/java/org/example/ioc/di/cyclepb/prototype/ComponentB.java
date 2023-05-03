package org.example.ioc.di.cyclepb.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
