package org.example.ioc.propertysource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liyunfei
 **/
@PropertySource(value = "classpath:test.properties")
//@PropertySource(value = "E:\\JavaProjects\\LearnProjects\\spring-advance-learn\\spring-annotation-analysis\\src\\main\\java\\org\\example\\ioc\\propertysource\\test.properties")
@Configuration
public class PropertySourceAnalysis {

}
