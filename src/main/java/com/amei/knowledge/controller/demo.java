package com.amei.knowledge.controller;

import com.amei.knowledge.annotion.Log;
import com.amei.knowledge.springboot.async.AsyncMethodTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("demo")
public class demo {
    @Autowired
    private AsyncMethodTask asyncMethodTask;

    @Log("#########做了一个测试#######3")
    @GetMapping("/hello")
    public String demo() {
        System.out.println("主线程 =====> 开始 =====> " + System.currentTimeMillis());
        asyncMethodTask.asyncMethodTaskWithVoidReturnType("a");
        System.out.println("主线程 =====> 结束 =====> " + System.currentTimeMillis());
        return "demo";
    }
}
