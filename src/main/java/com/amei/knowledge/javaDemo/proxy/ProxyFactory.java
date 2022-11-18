package com.amei.knowledge.javaDemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class ProxyFactory {
    private Object target; //维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),//目标对象的所有接口方法
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        //执行目标对象方法
                        method.invoke(target, args);
                        System.out.println("提交事务");
                        return null;
                    }
                });
    }

}
