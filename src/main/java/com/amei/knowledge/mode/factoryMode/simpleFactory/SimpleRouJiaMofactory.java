package com.amei.knowledge.mode.factoryMode.simpleFactory;

import com.amei.knowledge.mode.factoryMode.LaRouJiaMo;
import com.amei.knowledge.mode.factoryMode.SuanRoujiaMo;
import com.amei.knowledge.mode.factoryMode.TianRouJiaMo;
import com.amei.knowledge.mode.factoryMode.entity.RouJiaMo;

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
