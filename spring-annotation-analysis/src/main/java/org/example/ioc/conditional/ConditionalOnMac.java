package org.example.ioc.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author liyunfei
 **/
public class ConditionalOnMac implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Objects.requireNonNull(context.getEnvironment().getProperty("os.name").toLowerCase()).contains("mac");
    }
}
