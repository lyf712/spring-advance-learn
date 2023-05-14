package org.example.transaction.sample.service.impl;

import org.example.transaction.sample.dao.UserDao;
import org.example.transaction.sample.entity.User;
import org.example.transaction.sample.exception.TestException;
import org.example.transaction.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    // Transaction的理解
    /*
     1.分类（物理事务、逻辑事务）
     2.spring支持的事务：声明式、编程式
     3.回顾机制和超时处理
     4.对比有无事务的正常和异常情况

     5.应用场景，当有数据库update操作时（对于读则~），则需要考虑该操作之后是否有可能异常发生，
     另外考虑是否有多次的事务改变等情况

     */


    /*
        @AliasFor("transactionManager")
    String value() default "";
    @AliasFor("value")
    String transactionManager() default "";
    String[] label() default {};
    // 传播机制：代理机制有关，玩的是代理对象
    Propagation propagation() default Propagation.REQUIRED;
    // 隔离级别
    Isolation isolation() default Isolation.DEFAULT;
    // 超时，异常的界定
    int timeout() default -1;
    String timeoutString() default "";
    // 只读
    boolean readOnly() default false;
    // 回滚补偿机制
    Class<? extends Throwable>[] rollbackFor() default {};
    String[] rollbackForClassName() default {};
    Class<? extends Throwable>[] noRollbackFor() default {};
    String[] noRollbackForClassName() default {};
     */



    @Transactional(timeout = 1,rollbackFor = TestException.class)
    @Override
    public boolean register(User user) {
        //userDao.add(user.getId(), user.getUserName(), user.getAge());
        userDao.add(user);
        //int i = 1/0;

        // 超时的理解？？ https://blog.csdn.net/luoyang_java/article/details/105556722
        try {
            // 模拟其他操作..
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    // void excepetion(){}

}
