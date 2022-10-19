package com.amei.knowledge.设计模式.mode.builderMode;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Product aProduct = director.getAProduct();
        aProduct.showProduct();
        Product bProduct = director.getBProduct();
        bProduct.showProduct();
    }
}
