package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;

public class TopicSend {
    private final static String EXCHANGE_NAME="test_exchange_topic";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        //消息内容
        String message = "Hello World!!";
        channel.basicPublish(EXCHANGE_NAME,"routekey.1",null,message.getBytes());
        System.out.println("[x] send '"+message+"'");

        channel.close();
        connection.close();
    }
}
