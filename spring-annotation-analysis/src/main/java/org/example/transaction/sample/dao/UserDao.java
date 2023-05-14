package org.example.transaction.sample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.transaction.sample.entity.User;

/**
 * @author liyunfei
 **/
@Mapper
public interface UserDao {
    // 注意加上@Param,这样才能标识，思考底层框架mybatis,为何不设计自动识别默认~~，paramTypes,paramArgs,,,

//    @Insert("INSERT INTO user_transaction_demo(id,userName,age) VALUES(#{id},#{userName},#{age})")
//    void add(@Param("id") String id,@Param("userName") String userName,@Param("age") Integer age);

    @Insert("INSERT INTO user_transaction_demo(id,userName,age) VALUES(#{id},#{userName},#{age})")
    void add(User user);
}
