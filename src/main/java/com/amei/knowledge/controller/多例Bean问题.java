package com.amei.knowledge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 单例（ Singleton）：在整个应用中，只创建bean的一个实例。
 * 原型（ Prototype）：每次【注入】或者【通过Spring应用上下文】获取的时候，都会创建一个新的bean实例。
 */
@RestController()
@RequestMapping("beans")
//@Scope("prototype")
public class 多例Bean问题 {

    private String name;

    /**
     * 多线程下，name 的值会出现混乱。 解决方式，加注解@Scope("prototype")
     *
     * @param paraName
     * @return
     * @throws InterruptedException
     */
    @GetMapping
    public String getLog(@RequestParam("name") String paraName) throws InterruptedException {
        name = paraName;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + "  name:" + name);
            TimeUnit.SECONDS.sleep(1);
        }
        return name;
    }
}
