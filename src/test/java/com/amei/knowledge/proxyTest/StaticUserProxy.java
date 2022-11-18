package com.amei.knowledge.proxyTest;

import com.amei.knowledge.javaDemo.proxy.IUserDao;
import com.amei.knowledge.javaDemo.proxy.UserDao;
import com.amei.knowledge.javaDemo.proxy.UserDaoProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticUserProxy {

    @Test
    public void testStaticProxy() {
        //目标对象
        IUserDao target = new UserDao();
        //代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
