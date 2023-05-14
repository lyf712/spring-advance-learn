package org.example.transaction.sample.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author liyunfei
 **/
@Data
public class User implements Serializable {
       private static final long serialVersionUID = 6692313790847736493L;
       private String id;
       private String userName;
       private Integer age;

       public User(String name, Integer age) {
          this.id = UUID.randomUUID().toString().replace("-","");
          this.userName = name;
          this.age = age;
       }
}
