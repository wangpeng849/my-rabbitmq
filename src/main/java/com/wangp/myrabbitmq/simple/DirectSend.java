package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;
@Deprecated
public class DirectSend {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明（创建）exchange
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        //消息内容
        String message = "更新商品";
        channel.basicPublish(EXCHANGE_NAME,"insert",null,message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
