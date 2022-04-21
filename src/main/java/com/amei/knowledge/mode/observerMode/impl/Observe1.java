package com.amei.knowledge.mode.observerMode.impl;

import com.amei.knowledge.mode.observerMode.Observer;
import com.amei.knowledge.mode.observerMode.Subject;


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
