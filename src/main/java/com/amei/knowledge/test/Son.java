package com.amei.knowledge.test;


class Son extends Father {
    public void test() {

    }

    public static void main(String[] args) {
        Son son = new Son();
        Father father = son;
//        father.test();
    }
}
