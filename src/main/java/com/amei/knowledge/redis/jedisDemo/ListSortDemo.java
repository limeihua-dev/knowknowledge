package com.amei.knowledge.redis.jedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.List;

/**
 * 例如对商品排序，根据销量
 */
public class ListSortDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.flushDB();
        jedis.lpush("item-list-key", "1", "2", "3", "4", "5");
        List<String> list = jedis.lrange("item-list-key", 0, -1);
        System.out.println(list);
        jedis.hset("item-sort-1", "sales", "10");
        jedis.hset("item-sort-2", "sales", "9");
        jedis.hset("item-sort-3", "sales", "8");
        jedis.hset("item-sort-4", "sales", "7");
        jedis.hset("item-sort-5", "sales", "6");


        //通过sort排序
        SortingParams sortingParams = new SortingParams();
        sortingParams.by("item-sort-*->sales");
        sortingParams.asc();
        //将价格输出
        sortingParams.get("item-sort-*->sales");
        List<String> key = jedis.sort("item-list-key", sortingParams);
        System.out.println(key);

    }
}
