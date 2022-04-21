package com.amei.knowledge.entity;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress()); // Dog@7b23ec81
        func(dog);
        System.out.println(dog.getObjectAddress()); // Dog@7b23ec81
        System.out.println(dog.getName());          // A
    }

    /**
     * 著作权归https://pdai.tech所有。
     * 链接：https://pdai.tech/md/java/basic/java-basic-lan-basic.html
     *
     * 以下代码中 Dog dog 的 dog 是一个指针，存储的是对象的地址。
     * 在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中。因此在方法中改变指针引用的对象，那么这两个指针此时指向的是完全不同的对象，一方改变其所指向对象的内容对另一方没有影响。
     * @param dog
     */
    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress()); // Dog@7b23ec81
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress()); // Dog@6acbcfc0
        System.out.println(dog.getName());          // B
    }
}

