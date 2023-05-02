package org.example.ioc.denpendson;

/**
 * @author liyunfei
 **/
public abstract class AbstractDepensOnClass {
    static {
        System.out.println("AbstractDepensOnClass init~");
    }
    protected void init(){
        System.out.println("init " + getClass().getName());
    }
}
