package com.amei.knowledge.controller;

import com.amei.knowledge.annotion.Log;
import com.amei.knowledge.service.A;
import com.amei.knowledge.service.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cycle")
public class 循环依赖问题 {
    @Autowired
    private A a;
    @Autowired
    private B b;

    @Log("#########做了一个测试#######3")
    @GetMapping("/hello2")
    public String demo() {
//        a.setB(b);
//        A a = new A();
//        B b = new B();
//        a.setB(b);
        return "hello2";
    }
}
