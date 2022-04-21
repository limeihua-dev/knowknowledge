package com.amei.knowledge.mode.builderMode;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Product aProduct = director.getAProduct();
        aProduct.showProduct();
        Product bProduct = director.getBProduct();
        bProduct.showProduct();
    }
}
