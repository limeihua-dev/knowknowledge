package com.amei.knowledge.redis.jedisDemo;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        String ping = jedis.ping();
        System.out.println(ping);//PONG
    }
}
