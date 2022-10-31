package com.amei.knowledge.redis.jedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.HashMap;
import java.util.List;

/**
 * jedis 是redis 官方推荐的 java连接开发工具
 */
public class redisApiDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String ping = jedis.ping();
        jedis.select(0);
        System.out.println(ping);//PONG
        System.out.println("清空数据->" + jedis.flushDB());
        System.out.println("判断某个键是否存在：" + jedis.exists("limeihua"));
        System.out.println("新增键值对：" + jedis.set("limeihua", "18"));
        System.out.println("新增键值对：" + jedis.set("limeihua", "山西"));
        System.out.println("新增键值对：" + jedis.set("limeihua2", "山西"));
        System.out.println("系统中所有的键：");
        System.out.println(jedis.keys("*"));
        jedis.move("limeihua2", 1);//转移键 到 库 1
        System.out.println(jedis.keys("*"));
        //设置过期时间
        jedis.expire("limeihua", 1000);
        try {
            Thread.sleep(2000);
            //ttl Time-To-Live  生存时间值
            System.out.println("查看当前key剩余过期时间：" + jedis.ttl("limeihua"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 关于类型String
         */
        System.out.println("添加数据：");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键key1：" + jedis.del("key1"));
        System.out.println("判断键key1是否存在：" + jedis.exists("key1"));
        System.out.println("查看键key2所存储的类型：" + jedis.type("key2"));
        System.out.println("随机返回key空间中的一个" + jedis.randomKey());
        System.out.println("重命名：" + jedis.rename("key2", "key3"));
        System.out.println(jedis.get("key3"));
        System.out.println(jedis.keys("*"));
        System.out.println("在key3后面追加值：" + jedis.append("key3", "value222"));
        System.out.println("获取key3的值：" + jedis.get("key3"));
        System.out.println("获取多个键值对：" + jedis.mget("key1", "key2", "key3"));
        /**
         * 不存在则创建
         */
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key3", "value3"));
        System.out.println(jedis.keys("*"));

        System.out.println("清数据： " + jedis.flushDB());
        /**
         * 添加一个list
         */
        jedis.lpush("collections", "arraylist", "vector", "stack", "weakhashmap");
        jedis.lpush("collections", "hashset");
        jedis.lpush("collections", "treeset");
        jedis.lpush("collections", "treemap");
        jedis.lpush("collections", "hashset");
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 区间0-3的内容：" + jedis.lrange("collections", 0, 3));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collection的长度：" + jedis.llen("collections"));
        System.out.println("修改下标为1的内容：" + jedis.lset("collections", 1, "hashmap"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("----");
//        System.out.println("collections的内容: " + jedis.blpop(5, "treemap"));
        System.out.println("----");
//        System.out.println("collections的内容: " + jedis.brpop(5, "treemap"));
        System.out.println("----");
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));


        //获取元素
        System.out.println();
        System.out.println("获取collections下标为2的元素：" + jedis.lindex("collections", 1));

        //排序
        System.out.println("排序前：" + jedis.lrange("collections", 0, -1));
        SortingParams sortingParams = new SortingParams();
        SortingParams alpha = sortingParams.alpha();//alpha 按字母排序
        SortingParams desc = sortingParams.desc();//desc 降序排序
        List<String> collections = jedis.sort("collections", alpha);
        System.out.println("排序后：" + collections);

        //删除元素
        System.out.println("删除下表为0-3之外的元素: " + jedis.ltrim("collections", 0, 3));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections列表出栈（左栈）：" + jedis.lpop("collections"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections列表出栈（右栈）：" + jedis.rpop("collections"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));

        /**
         * 关于hashMap
         */
        jedis.flushDB();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");
        hashMap.put("k3", "v3");
        hashMap.put("k4", "v4");
        hashMap.put("k5", "v5");
        //新增
        jedis.hmset("hash", hashMap);//hmset   添加多个键值对
        jedis.hset("hash", "k6", "v6");
        System.out.println("获取散列hash的所有键值对：" + jedis.hgetAll("hash"));
        System.out.println("获取散列hash的所有键：" + jedis.hkeys("hash"));
        System.out.println("获取散列hash的所有值：" + jedis.hvals("hash"));
        System.out.println("判断key是否存在：" + jedis.hexists("hash", "k1"));
        System.out.println("获取hash中的值：" + jedis.hmget("hash", "k1", "k2"));


        /**
         * 关于zset 有序集合
         */
        System.out.println(jedis.zadd("salary", 2500, "jack"));
        System.out.println(jedis.zadd("salary", 5000, "tom"));
        System.out.println(jedis.zadd("salary", 15000, "peter"));

        // Inf无穷大量+∞,同样地,-∞可以表示为-Inf。
        System.out.println(jedis.zrangeByScore("score", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));// zrangebyscore salary -inf +inf
        //递减排列
//        System.out.println(jedis.zrevrange(""));

    }
}
