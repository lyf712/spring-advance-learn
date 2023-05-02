package org.example.ioc.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration
public class ConditionTestBean {
    class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Conditional(ConditionalOnWin.class)
    @Bean("win")
    Person winPerson(){return new Person("windows");}
    @Conditional(ConditionalOnMac.class)
    @Bean("mac")
    Person macPerson(){return new Person("macos");}
}
