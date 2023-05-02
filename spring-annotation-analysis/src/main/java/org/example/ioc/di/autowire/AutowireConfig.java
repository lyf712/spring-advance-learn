package org.example.ioc.di.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration
@ComponentScan
public class AutowireConfig {
    @Autowired
            // @Qualifier(value = "component1")
    Component1 component1;

    @Autowired(required = false)
    Component2 component2;

    final Component1 component3;

    Component1 component4;

    Component2 component5;

//    public AutowireConfig(Component1 component3) {
//        this.component3 = component3;
//    }



    public AutowireConfig(Component1 component3) {//, Component2 component5
        this.component3 = component3;
        ///this.component5 = component5;
    }

    @Override
    public String toString() {
        return "AutowireConfig{" +
                "component1=" + component1 +
                ", component2=" + component2 +
                ", component3=" + component3 +
                ", component4=" + component4 +
                ", component5=" + component5 +
                '}';
    }
}
