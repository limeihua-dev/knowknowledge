package com.amei.knowledge.设计模式.原型模式.impl;

import com.amei.knowledge.设计模式.原型模式.Product;

/**
 * 案例是，讲字符串放入方框中显示或是加上下划线
 */
public class ProductImpl implements Product {

    private char decochar;

    public ProductImpl(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() throws CloneNotSupportedException {
        Product product = null;
        product = (Product) clone();
        return product;
    }
}
