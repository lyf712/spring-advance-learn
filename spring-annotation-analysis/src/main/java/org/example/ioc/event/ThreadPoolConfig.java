package org.example.ioc.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liyunfei
 **/
@Configuration
public class ThreadPoolConfig {
    @Bean("pool-1")
    Executor executorPool1(){
        //ThreadPoolExecutor executor = new ThreadPoolExecutor();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        //
        return executor;
    }
}
