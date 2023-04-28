package org.example.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 业务逻辑：
 * 理解业务逻辑和非功能性逻辑的设计、抽离，使得系统进一步解耦！
 *
 * @author liyunfei
 **/
@Service
public class DemoService {
       public boolean login(Map<String,String> params){
              // check
              System.out.println("login service");
              return true;
       }
}
