package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.wangp.myrabbitmq.util.ConnectionUtil;

public class Recv3 {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception{
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //
        channel.basicQos(5);
        //定义消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[z] Received '"+message+" '");
            //休眠一秒
            Thread.sleep(1000);
        }
    }
}
