package com.zenghm.spring.cloud.spring.rabbitmq.producer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ZJBR
 * @date 2020/8/24
 * @description xxx
 */
public class RabbitmqProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory(); // 连接工厂
        factory.setHost("10.60.49.182");
        factory.setPort(5672);
        factory.setUsername("airlen");
        factory.setPassword("1234");

        Connection connection = factory.newConnection(); // 创建连接
        Channel channel = connection.createChannel(); // 创建信道

        channel.exchangeDeclare("demo.exchange", "direct"); // 创建交换器  direct？
        channel.queueDeclare("demo.queue", false, false, false, null);  // 创建队列
        channel.queueBind("demo.queue", "demo.exchange", "com.zenghm.spring.cloud.rabbitmq"); // 绑定交换器与队列 关系

        String message = "进错教室";
        channel.basicPublish("demo.exchange",
                "com.zenghm.spring.cloud.rabbitmq",
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        channel.close();
        connection.close();
    }

}
