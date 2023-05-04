package org.example.ioc.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author liyunfei
 **/
@Component
public class SyncMyEventListenerV2 {
    @EventListener(MyEvent.class)
    public void onApplicationEvent(MyEvent event) {
        System.out.println("SyncMyEventListenerV2 listener MyEvent...");
        if(event.getSubType().compareTo(MyEvent.SubType.SYNC) == 0){
            System.out.println("SyncMyEventListener handle the "+ event +" at "+ System.currentTimeMillis());
        }
    }
}
