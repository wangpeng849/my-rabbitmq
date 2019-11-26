package com.wangp.myrabbitmq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;
 
/**
 * 订阅
 */
public class C_Subscribe_Sender{
    private final static String EXCHANGE_NAME = "direct_exchange";
    private final static String EXCHANGE_TYPE = "direct";
 
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
 
        channel.exchangeDeclare(EXCHANGE_NAME,EXCHANGE_TYPE);
 
        String message = "那一定是蓝色";
        channel.basicPublish(EXCHANGE_NAME,"key2", null, message.getBytes());
        System.out.println("[x] Sent '"+message+"'");
 
        channel.close();
        connection.close();
    }
}