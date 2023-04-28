package org.example.ioc.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liyunfei
 **/
public class MyImportSelectorBeanConfig implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Bean1.class.getName(),Bean2.class.getName()};
    }
}
