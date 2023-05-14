package org.example.transaction.sample.service;

import org.example.transaction.sample.entity.User;

/**
 * @author liyunfei
 **/
public interface UserService {
    /**
     * 用户注册接口.
     * @param user u
     * @return b
     */
    boolean register(User user);
}
