package com.amei.knowledge.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureMallDemo {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("taobao"),
            new NetMall("pdd")
    );

    //一个一个按序执行
    public static List<String> getPrice(List<NetMall> list, String produceName) {
        return list.stream()
                .map(netMall -> String.format(produceName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(produceName)))
                .collect(Collectors.toList());
    }

    //使用CompletableFuture执行
    public static List<String> getPriceCompletableFuture(List<NetMall> list, String produceName) {
        List<CompletableFuture<String>> collect = list.stream()
                .map(netMall -> CompletableFuture.supplyAsync(() -> String.format(produceName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(produceName))))
                .collect(Collectors.toList());
        return collect.stream().map(s -> s.join()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        List<String> mysql = getPrice(list, "mysql");
//        for (String str : mysql) {
//            System.out.println(str);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
//
//        long startTime2 = System.currentTimeMillis();
//        List<String> mysql1 = getPriceCompletableFuture(list, "mysql");
//        for (String str : mysql1) {
//            System.out.println(str);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println(endTime2 - startTime2);

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        //thenApply的使用
        CompletableFuture.supplyAsync(() ->
                {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }, newFixedThreadPool
        ).thenApply(f -> {
                    return f + 2;
                }
        ).thenApply(f -> {
                    return f + 2;
                }
        ).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果：" + v);
            }
        }).exceptionally(e -> {
            e.getMessage();
            return null;
        });
        newFixedThreadPool.shutdown();
    }

    @Data
    @AllArgsConstructor
    static class NetMall {
        @Getter
        public String netMallName;

        public double calcPrice(String productName) {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double v = ThreadLocalRandom.current().nextDouble() * 2;
            return v + productName.charAt(0);
        }
    }
}
