package com.amei.knowledge.redis.jedisDemo;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class jedisTransational {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "zlc");

        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toString();

        //执行事务
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            multi.exec();
        } catch (Exception exception) {
            multi.discard();
            exception.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            //关闭链接
            jedis.close();
        }
    }
}
