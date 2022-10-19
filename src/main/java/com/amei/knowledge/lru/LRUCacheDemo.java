package com.amei.knowledge.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo extends LinkedHashMap {
    private int capacity;//缓存坑位

    public LRUCacheDemo(int capacity) {
//        super(capacity, 0.75f, false);
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        lruCacheDemo.put(3, "c");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "x");
        System.out.println(lruCacheDemo.keySet());
    }
}
