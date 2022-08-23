package com.amei.knowledge.rabbitMq;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@RabbitListener(queues = {RabbitMQConfig.RABBITMQ_DEMO_TOPIC})
public class RabbitDemoConsumer {

//    @RabbitHandler
    public void process(Map map)
    {
        System.out.println("消费者RabbitDemoConsumer从RabbitMQ服务端消费消息：" + map.toString());
    }

}
