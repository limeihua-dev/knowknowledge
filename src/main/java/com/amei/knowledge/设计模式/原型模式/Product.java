package com.amei.knowledge.设计模式.原型模式;

/**
 * 复制功能的接口
 */
public interface Product extends Cloneable {

    public abstract void use(String s);

    public abstract Product createClone() throws CloneNotSupportedException;
}
