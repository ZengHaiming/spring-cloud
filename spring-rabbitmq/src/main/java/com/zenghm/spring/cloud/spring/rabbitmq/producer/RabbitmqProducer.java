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

        /**
         * 交互器 类型
         * fanout 它会把所有发送到该交换器的消息，路由到所有与该交换器绑定的队列中
         * direct 把消息路由到那些BindingKey和RoutingKey完全匹配的队列中
         * topic 类似于direct，但可以使用通配符匹配规则
         *   BindingKey允许使用两种符号用于模糊匹配：“*”与“#”
         *  “*”可匹配一个单词；
         *  “#”可匹配零个或多个单词。
         * header 消息不根据路由键的匹配规则路由，而是根据发送的消息内容中的headers属性进行匹配
         */

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
