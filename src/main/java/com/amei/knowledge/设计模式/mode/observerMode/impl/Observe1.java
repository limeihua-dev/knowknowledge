package com.amei.knowledge.设计模式.mode.observerMode.impl;

import com.amei.knowledge.设计模式.mode.observerMode.Observer;
import com.amei.knowledge.设计模式.mode.observerMode.Subject;


public class Observe1 implements Observer {

    private Subject subject;

    public Observe1(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("观察者1：得到消息" + msg);
    }
}
