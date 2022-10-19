package com.amei.knowledge.设计模式.mode.factoryMode;

import com.amei.knowledge.设计模式.mode.factoryMode.entity.RouJiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.simpleFactory.SimpleRouJiaMofactory;

public class RouJiaMoStore {

    private SimpleRouJiaMofactory simpleRouJiaMofactory;

    public RouJiaMoStore(SimpleRouJiaMofactory simpleRouJiaMofactory) {
        this.simpleRouJiaMofactory = simpleRouJiaMofactory;
    }

    /**
     * 根据传入类型不同卖不同的肉夹馍
     *
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMo(String type) {
        RouJiaMo rouJiaMo = simpleRouJiaMofactory.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }
}
