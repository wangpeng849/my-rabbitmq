package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;

public class Send {
    public static final String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消息内容
        int count = 0;
        while (true) {
            String message = "hello rabbitmq" + (count++);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x] Sent '" + message + "'");
            if (count == 100) {
                break;
            }
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
