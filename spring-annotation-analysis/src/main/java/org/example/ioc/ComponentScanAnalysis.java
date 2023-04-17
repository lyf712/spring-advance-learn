package org.example.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 关键理解 include和exclude 及 filter的使用
 * 对于代理方式、懒加载等定义可暂放
 *
 * 思考：Spring在设计该注解时，是如何去定义问题，抽象Bean的类型（通过注解、类名，交由用户自定义filter）去排除或指定扫描加载
 *
 * @author liyunfei
 **/
// @ComponentScans(value = {@ComponentScan(),@ComponentScan()} )
//@ComponentScan(basePackages = {"org.example.ioc.scanpackage",""},
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}))
@ComponentScan(basePackages = {"org.example.ioc.scanpackage"},
       includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyComponentScanFilter.class}),
       // 注意需要禁止掉，不然会扫描默认的注解@Controller,...
        useDefaultFilters = false)
public class ComponentScanAnalysis {
    /**
     * @SpringBootApplication组合注解：
     *
     * @Target({ElementType.TYPE})
     * @Retention(RetentionPolicy.RUNTIME)
     * @Documented
     * @Inherited
     * @SpringBootConfiguration
     * @EnableAutoConfiguration
     * @ComponentScan(
     *     excludeFilters = {@Filter(
     *     type = FilterType.CUSTOM,
     *     classes = {TypeExcludeFilter.class}
     * ), @Filter(
     *     type = FilterType.CUSTOM,
     *     classes = {AutoConfigurationExcludeFilter.class}
     * )}
     * )
     * public @interface SpringBootApplication {
     *     @AliasFor(
     *         annotation = EnableAutoConfiguration.class
     *     )
     *     Class<?>[] exclude() default {};
     *
     *     @AliasFor(
     *         annotation = EnableAutoConfiguration.class
     *     )
     *     String[] excludeName() default {};
     *
     *     @AliasFor(
     *         annotation = ComponentScan.class,
     *         attribute = "basePackages"
     *     )
     *     String[] scanBasePackages() default {};
     *
     *     @AliasFor(
     *         annotation = ComponentScan.class,
     *         attribute = "basePackageClasses"
     *     )
     *     Class<?>[] scanBasePackageClasses() default {};
     *
     *     @AliasFor(
     *         annotation = Configuration.class
     *     )
     *     boolean proxyBeanMethods() default true;
     * }
     */

}
