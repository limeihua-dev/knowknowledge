package com.amei.knowledge.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Controller(value = "OK")
public class Test {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new RootBeanDefinition(Test.class);
        defaultListableBeanFactory.registerBeanDefinition("test", beanDefinition);
        System.out.println(Arrays.toString(defaultListableBeanFactory.getBeanNamesForAnnotation(Controller.class)));
        //[test]
        System.out.println(defaultListableBeanFactory.findAnnotationOnBean("test",Controller.class));
        //@org.springframework.stereotype.Controller(value=OK)
    }
}
