package com.zenghm.spring.cloud.spring.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ZJBR
 * @date 2020/8/24
 * @description xxx
 */
public class RabbitmqConsumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory(); // 连接工厂
        factory.setUsername("airlen");
        factory.setPassword("1234");

        Address[] addresses = {new Address("10.60.49.182", 5672)};
        Connection connection = factory.newConnection(addresses);

        final Channel channel = connection.createChannel();

        channel.basicConsume("demo.queue", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("Consumer 消费了消息："+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false); //告诉MQ 消费了消息  （消息确认机制）
            }
        });

        Thread.sleep(1000);

        channel.close();
        connection.close();

    }
}
