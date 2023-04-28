package org.example.ioc.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liyunfei
 **/
@Import(value = {MyImportOrdinaryBean.class, MyImportSelectorBeanConfig.class, MyImportBeanRegistraBeanRegistry.class})
@Configuration
public class ImportAnalysis {
    /**
     * springboot自动加载
     * @LINK AutoConfigurationImportSelector
     *
     */



}
