package com.amei.knowledge.设计模式.mode.factoryMode.abstractFactory;

public interface RouJiaMoFactory {
    /**
     * 生产肉
     */

    public String createMeat();

    /**
     * 生产调料
     */
    public String createYuanLiao();
}
