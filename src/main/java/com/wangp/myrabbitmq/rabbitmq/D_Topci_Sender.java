package com.wangp.myrabbitmq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;

import java.io.IOException;
 

public class D_Topci_Sender {
    private final static String EXCHANGE_NAME = "exchange_topic";
    private final static String EXCHANGE_TYPE = "topic";
 
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
 
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
 
        //消息内容
        String message = "如果真爱有颜色";
        channel.basicPublish(EXCHANGE_NAME,"key.1",null,message.getBytes());
        System.out.println("[x] Sent '"+message+"'");
 
        //关通道 关连接
        channel.close();
        connection.close();
    }
}