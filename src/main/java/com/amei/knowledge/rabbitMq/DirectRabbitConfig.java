package com.amei.knowledge.rabbitMq;

import com.rabbitmq.client.AMQP;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
    public AMQP.Queue rabbitmqDemoDirectQueue() {
        return new AMQP.Queue();
    }
}
