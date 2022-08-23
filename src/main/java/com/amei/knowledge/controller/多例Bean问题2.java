package com.amei.knowledge.controller;

import com.amei.knowledge.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller层为单例模式，service层为多例模式,service注入controller时，会使name值混乱。
 * 解决办法：使用反射获取时，不会出现问题。
 * <p>
 * 原因是，prototype 在注入时创建或者获取上下文时创建。在项目启动时，service就被注入。
 */
@RestController()
@RequestMapping("beans2")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class 多例Bean问题2 {

    @Autowired
    Dog dog;

    private String name;

    /**
     * 多线程下，name 的值会出现混乱。 解决方式，加注解@Scope("prototype")
     *
     * @param paraName
     * @return
     * @throws InterruptedException
     */
    @GetMapping("{name}")
    public String getLog(@PathVariable("name") String paraName) {
        name = paraName;
//        Dog dog = SpringBeanUtil.getBean(Dog.class);
        dog.setName(name);
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println(
                        Thread.currentThread().getId()
                                + "name:" + dog.getName());
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paraName;
    }
}
