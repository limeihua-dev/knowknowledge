package com.amei.knowledge.javaDemo.proxy;

/**
 * 静态代理类
 */
public class UserDaoProxy implements IUserDao {
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
