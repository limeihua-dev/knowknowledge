package com.amei.knowledge.proxyTest;

import com.amei.knowledge.javaDemo.proxy.CglibProxyDemo;
import com.amei.knowledge.javaDemo.proxy.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testCglibProxy {

    @Test
    public void testCglibProxy(){
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new CglibProxyDemo(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }
}
