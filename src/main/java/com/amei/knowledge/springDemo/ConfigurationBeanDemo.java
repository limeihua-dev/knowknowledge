package com.amei.knowledge.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ConfigurationBeanDemo {
    public static void main(String[] args) {
        //有@Configuration注解
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
        //无@Configuration注解
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ConfigBean1.class);
//        for (String beanName : context.getBeanDefinitionNames()) {
//            //别名
//            String[] aliases = context.getAliases(beanName);
//            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
//                    beanName,
//                    Arrays.asList(aliases),
//                    context.getBean(beanName)));
//        }
        System.out.println("==========");
        for (String beanName : context1.getBeanDefinitionNames()) {
            //别名
            String[] aliases = context1.getAliases(beanName);
            System.out.println(String.format("bean名称:%s,别名:%s,bean对象:%s",
                    beanName,
                    Arrays.asList(aliases),
                    context1.getBean(beanName)));
        }
    }

    //Service被调用了三次，如果不使用Configuration
}
