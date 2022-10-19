package com.amei.knowledge.transactionDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionalDemo {


    @Autowired
     MongoTemplate mongoTemplate;

    public void parentMethods() {
        A(10);
        B(10);
//        int i = 1 / 0;
        throw new NullPointerException();
    }

    //将传入参数a存入Table
    public void A(int age) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "a");
        map.put("age", age);
        mongoTemplate.insert(map, "com.ns.entity.business.BusinessModel");
    }

    //将传入参数b存入Table
    @Transactional(rollbackFor = Exception.class)
    public void B(int age) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "b");
        map.put("age", age);
        mongoTemplate.insert(map, "com.ns.entity.business.BusinessModel");
        int i = 1 / 0;
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "c");
        map2.put("age", age);
        mongoTemplate.insert(map2, "com.ns.entity.business.BusinessModel");
    }

    /**
     * 添加操作
     */
    @Transactional
    public void childOneMethods() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "a");
        map.put("age", 10);
        mongoTemplate.insert(map, "com.ns.entity.business.BusinessModel");
    }

    /**
     * 更改操作
     */
    @Transactional
    public void childTwoMethods() {
    }


    @Transactional
    public boolean create() {
        int i = 0;
        try {
            addPerson();
        } catch (Exception e) {
            System.out.println("不断程序，用来输出日志~");
        }
        return i == 1;
    }

    @Transactional
    public boolean addPerson() {
        System.out.println(1 / 0);
        return false;
    }

}
