package com.amei.knowledge.设计模式.原型模式;

import com.amei.knowledge.设计模式.原型模式.impl.ProductImpl;

public class prototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        //准备
        Manager manager = new Manager();
        ProductImpl product = new ProductImpl('*');
        manager.register("star", product);
        //生成
        Product product1 = manager.create("star");
        product1.use("hello world!");
    }
}
