package com.amei.knowledge.mode.factoryMode.abstractFactory;

import com.amei.knowledge.mode.factoryMode.entity.RouJiaMo;

public class XianRoujiaMoFactory implements RouJiaMoFactory {
    @Override
    public String createMeat() {
        return null;
    }

    @Override
    public String createYuanLiao() {
        return null;
    }
}
