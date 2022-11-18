package com.amei.knowledge.proxyTest;

import com.amei.knowledge.javaDemo.proxy.IUserDao;
import com.amei.knowledge.javaDemo.proxy.ProxyFactory;
import com.amei.knowledge.javaDemo.proxy.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProxy {
    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
