package com.amei.knowledge.rabbitMq.config;

public class RabbitMQConfig {
    /**
     * RabbitMQ的队列主题名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    /**
     * RabbitMQ的Direct交换机名称
     */
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";

    /**
     * RabbitMQ的Direct交换机与队列绑定的匹配键
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";
}
