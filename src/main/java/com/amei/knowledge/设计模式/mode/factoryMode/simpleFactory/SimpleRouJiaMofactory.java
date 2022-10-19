package com.amei.knowledge.设计模式.mode.factoryMode.simpleFactory;

import com.amei.knowledge.设计模式.mode.factoryMode.LaRouJiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.SuanRoujiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.TianRouJiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.entity.RouJiaMo;

public class SimpleRouJiaMofactory {
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        if (type.equals("Suan")) {
            rouJiaMo = new SuanRoujiaMo();
        } else if (type.equals("Tian")) {
            rouJiaMo = new TianRouJiaMo();
        } else if (type.equals("La")) {
            rouJiaMo = new LaRouJiaMo();
        }
        return rouJiaMo;
    }
}
