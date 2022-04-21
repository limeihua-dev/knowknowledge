package com.amei.knowledge.mode.observerMode.impl;

import com.amei.knowledge.mode.observerMode.Observer;
import com.amei.knowledge.mode.observerMode.Subject;

public class Observe2 implements Observer {
    private Subject subject;

    public Observe2(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("观察者2：得到消息" + msg);
    }
}
