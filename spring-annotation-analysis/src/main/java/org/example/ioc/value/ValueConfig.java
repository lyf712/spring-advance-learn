package org.example.ioc.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @author liyunfei
 **/
@Configuration //(value = "ValueConfig")
@PropertySource(value = {"classpath:self_config.properties"})
public class ValueConfig {
    /**
     * ${}:获取系统，环境ENV的值
     * #{}:SEl表达式处理
     */
    // 内置的环境变量
    @Value("${os.name}")
    String osName;
    @Value("${db.type}")
    String dbType;
    @Value("test")
    String testValue;
    @Value("#{1+1}")
    Integer intValue;
    @Value("https://www.baidu.com")
    Resource resource;

    public String getOsName() {
        return osName;
    }

    public String getDbType() {
        return dbType;
    }

    public String getTestValue() {
        return testValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return "ValueConfig{" +
                "osName='" + osName + '\'' +
                ", dbType='" + dbType + '\'' +
                ", testValue='" + testValue + '\'' +
                ", intValue=" + intValue +
                ", resource=" + resource +
                '}';
    }
}
