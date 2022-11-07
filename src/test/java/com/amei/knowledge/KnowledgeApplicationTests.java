package com.amei.knowledge;

import com.amei.knowledge.springboot.async.AsyncMethodTask;
import com.amei.knowledge.transactionDemo.TransactionalDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

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
        asyncMethodTask.asyncMethodTaskWithVoidReturnType("a");
    }


}
