package com.amei.knowledge.thread;

import java.util.concurrent.Callable;

public class ImplementCallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 1 / 0;
        return 1 + 1;
    }
}
