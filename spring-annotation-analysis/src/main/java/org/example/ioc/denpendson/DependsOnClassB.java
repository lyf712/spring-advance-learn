package org.example.ioc.denpendson;

import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component(value = "DependsOnClassB")
public class DependsOnClassB extends AbstractDepensOnClass{
    public DependsOnClassB(){init();}
}
