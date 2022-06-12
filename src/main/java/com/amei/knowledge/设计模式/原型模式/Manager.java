package com.amei.knowledge.设计模式.原型模式;


import com.amei.knowledge.设计模式.原型模式.Product;

import java.util.HashMap;

/**
 * 使用Product接口来复制
 */
public class Manager {
    //保存了实例的名字和实例之间的对应关系
    private HashMap showCase = new HashMap();

    public void register(String name, Product product) {
        showCase.put(name, product);
    }

    public Product create(String productName) throws CloneNotSupportedException {
        Product product = (Product) showCase.get(productName);
        return product.createClone();
    }

}
