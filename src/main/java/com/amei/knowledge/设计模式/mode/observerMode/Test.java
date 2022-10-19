package com.amei.knowledge.设计模式.mode.observerMode;

import com.amei.knowledge.设计模式.mode.observerMode.impl.ObjectFor3D;
import com.amei.knowledge.设计模式.mode.observerMode.impl.Observe1;

public class Test {
    public static void main(String[] args) {
        ObjectFor3D objectFor3D = new ObjectFor3D();
        Observe1 observe1 = new Observe1(objectFor3D);
        Observe1 observe2 = new Observe1(objectFor3D);
        objectFor3D.setMsg("23333");
    }
}
