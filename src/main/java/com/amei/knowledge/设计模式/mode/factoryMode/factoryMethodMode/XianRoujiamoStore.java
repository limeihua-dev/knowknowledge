package com.amei.knowledge.设计模式.mode.factoryMode.factoryMethodMode;

import com.amei.knowledge.设计模式.mode.factoryMode.LaRouJiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.SuanRoujiaMo;
import com.amei.knowledge.设计模式.mode.factoryMode.entity.RouJiaMo;

public class XianRoujiamoStore extends RouJiaMoStore {
    @Override
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        if (type.equals("Suan")) {
//            rouJiaMo = new XianSuanRoujiaMo();
            rouJiaMo = new SuanRoujiaMo();
        } else {
            rouJiaMo = new LaRouJiaMo();
        }

        return rouJiaMo;
    }
}
