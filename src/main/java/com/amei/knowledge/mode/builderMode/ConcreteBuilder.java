package com.amei.knowledge.mode.builderMode;

public class ConcreteBuilder extends Builder {

    private Product product = new Product();

    @Override
    public void setPart(String arg1, String arg2) {
        product.setName(arg1);
        product.setType(arg2);
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
