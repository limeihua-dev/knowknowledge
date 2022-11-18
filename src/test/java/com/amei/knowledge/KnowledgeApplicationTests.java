package com.amei.knowledge;

import com.amei.knowledge.entity.Dog;
import com.amei.knowledge.springboot.async.AsyncMethodTask;
import com.amei.knowledge.transactionDemo.TransactionalDemo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class KnowledgeApplicationTests {

    @Autowired
    TransactionalDemo transactionalDemo;

    @Autowired
    private AsyncMethodTask asyncMethodTask;
    @Autowired
    ApplicationContext applicationContext;


    static final String FORM_DEFINITION_PATH = "src/main/resources/basic_model/form";
    static final String FORM_DEFINITION_TEMPLATE_PATH = "src/main/resources/basic_model/form/template";

    @Test
    void contextLoads() {
        System.out.println("主线程 =====> 开始 =====> " + System.currentTimeMillis());
        asyncMethodTask.asyncMethodTaskWithVoidReturnType("a");
        System.out.println("主线程 =====> 结束 =====> " + System.currentTimeMillis());
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        Dog dog = new Dog("jerry");
        redisTemplate.opsForValue().set("cat", dog);
//        Object cat = redisTemplate.opsForValue().get("cat");
//        System.out.println(cat);
    }




}
