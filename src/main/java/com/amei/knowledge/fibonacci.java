package com.amei.knowledge;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class fibonacci {

    private static HashMap<Integer, Long> cache = new HashMap<>();

    static long fibonacci(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;

        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("Slow calculation of " + key);

            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }

    public static void main(String[] args) {
        // warm up
        for (int i = 0; i < 101; i++)
            System.out.println(
                    "f(" + i + ") = " + fibonacci(i));

        // read -> cal
        long current = System.currentTimeMillis();
        System.out.println(fibonacci(100));
        System.out.println(System.currentTimeMillis()-current);
    }
}
