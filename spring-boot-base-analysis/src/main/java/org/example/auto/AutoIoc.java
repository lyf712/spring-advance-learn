package org.example.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author liyunfei
 **/
public class AutoIoc {
    public void auto(){
        // context,web
        ApplicationContext context=new XmlWebApplicationContext();
        ApplicationContext context1 = new AnnotationConfigApplicationContext();
    }
}
