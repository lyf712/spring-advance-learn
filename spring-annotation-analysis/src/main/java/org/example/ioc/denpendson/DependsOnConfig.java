package org.example.ioc.denpendson;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyunfei
 **/
@Configuration
@ComponentScan(basePackages = DependsOnConfig.path)
public class DependsOnConfig {
    static final String path = "org.example.ioc.denpendson";
}
