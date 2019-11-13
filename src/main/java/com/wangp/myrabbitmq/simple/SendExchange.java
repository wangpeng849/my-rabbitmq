package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;

public class SendExchange {
    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //消息内容
        String message = "Hello World";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("[x] send '"+message+"'");

        channel.close();
        connection.close();
    }
}
