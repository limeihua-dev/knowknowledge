package com.amei.knowledge.设计模式.迭代器模式;

import java.util.Iterator;

/**
 * 表示集合的接口
 */
public interface Aggregate {
    public abstract Iterator iterator();
}
