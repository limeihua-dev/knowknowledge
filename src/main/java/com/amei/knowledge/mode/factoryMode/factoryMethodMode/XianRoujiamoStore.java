package com.amei.knowledge.mode.factoryMode.factoryMethodMode;

import com.amei.knowledge.mode.factoryMode.LaRouJiaMo;
import com.amei.knowledge.mode.factoryMode.SuanRoujiaMo;
import com.amei.knowledge.mode.factoryMode.entity.RouJiaMo;

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
