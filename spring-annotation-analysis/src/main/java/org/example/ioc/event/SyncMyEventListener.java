package org.example.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class SyncMyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("SyncMyEventListener listener MyEvent...");
        if(event.getSubType().compareTo(MyEvent.SubType.SYNC) == 0){
            System.out.println("SyncMyEventListener handle the "+ event +" at "+ System.currentTimeMillis());
        }
    }
}
