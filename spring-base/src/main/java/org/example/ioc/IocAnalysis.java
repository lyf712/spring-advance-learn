package org.example.ioc;

import javafx.application.Application;
import org.example.ioc.nonioc.PersonDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.StaticListableBeanFactory;

/**
 * 关键接口：
 * BeanFactory,ApplicationContext
 * @author liyunfei
 **/
public class IocAnalysis {

    @Autowired
    PersonDao personDao;

    public static void main(String[] args) {
        BeanFactory beanFactory = new StaticListableBeanFactory();
        // beanFactory.containsBean();

    }
}
