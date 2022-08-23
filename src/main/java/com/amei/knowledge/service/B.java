package com.amei.knowledge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class B {
    @Autowired
    private A a;

    public void setA(A a) {
        this.a = a;
        System.out.println("setA");
    }
}
