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
