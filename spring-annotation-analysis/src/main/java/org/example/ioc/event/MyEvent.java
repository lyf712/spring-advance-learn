package org.example.ioc.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件：对比MQ中的消息.
 *
 * @author liyunfei
 **/
public class MyEvent extends ApplicationEvent {

    private String name;

    private Class<?> mainType;

    public enum SubType{
        // 异步
        ASYNC,
        // 同步
        SYNC
    }

    SubType subType;

    public MyEvent(Object source,String name,SubType subType) {
        super(source);
        this.name = name;
        this.mainType = getClass();
        this.subType = subType;
    }

    public String getName() {
        return name;
    }

    public Class<?> getMainType() {
        return mainType;
    }

    public SubType getSubType() {
        return subType;
    }
}
