package com.amei.knowledge.spiDemo;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<Search> load = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = load.iterator();
        while (iterator.hasNext()) {
            Search next = iterator.next();
            next.searchDoc("dd");
        }
    }
}
