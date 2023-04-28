package org.example.ioc.imports;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liyunfei
 **/
public class MyImportBeanRegistraBeanRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
        BeanDefinition beanDefinition = new RootBeanDefinition(Bean3.class);
        // 容器直接注册
        registry.registerBeanDefinition(Bean3.class.getName(),beanDefinition);
    }
}
