package com.amei.knowledge.controller;

import com.amei.knowledge.annotion.Log;
import com.amei.knowledge.transactionDemo.TransactionalDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessTypeAspect {

    @Autowired
    TransactionalDemo transactionalDemo;

    @Log("#########做了一个测试#######3")
    @GetMapping("/hello")
    public String getLog(@RequestParam("name") String name) {
//        System.out.println(" 调用方法" + "  spring版本" + SpringVersion.getVersion() + "  springboot版本： " + SpringBootVersion.getVersion());
//        try {
//            int i = 1 / 0;
//        } catch (Exception ex) {
//            System.out.println("捕获异常");
//        }
//        return "annotion" + name;
        transactionalDemo.parentMethods();
        return "ok";
    }


}
