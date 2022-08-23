package com.amei.knowledge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
public class A {
    @Autowired
    private B b;

    public void setB(B b) {
        this.b = b;
        System.out.println("setB");
    }
}
