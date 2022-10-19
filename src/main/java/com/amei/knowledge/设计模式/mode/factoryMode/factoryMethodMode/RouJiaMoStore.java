package com.amei.knowledge.设计模式.mode.factoryMode.factoryMethodMode;

import com.amei.knowledge.设计模式.mode.factoryMode.entity.RouJiaMo;

public abstract class RouJiaMoStore {

    //定义创建对象的接口
    //由子类决定实例化的类
    public abstract RouJiaMo createRouJiaMo(String type);

    /**
     * 根据传入类型卖不同的肉夹馍
     *
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMo(String type) {
        RouJiaMo rouJiaMo = createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
