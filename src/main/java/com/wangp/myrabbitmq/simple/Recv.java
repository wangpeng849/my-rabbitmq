package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.*;
import com.wangp.myrabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Recv {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception{
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        //定义消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列 false表示手动返回完成状态，true表示自动
        /**
         * 模式1：自动确认
         * 只要消息从队列中获取，无论消费者获取到消息后是否成功消息，都认为是消息已经成功消费。
         * 模式2：手动确认
         * 消费者从队列中获取消息后，服务器会将该消息标记为不可用状态，等待消费者的反馈，如果消费者一直没有反馈，那么该消息将一直处于不可用状态。
         * false表示手动返回完成状态，true表示自动
         */
        channel.basicConsume(QUEUE_NAME,false,consumer);

        int count = 0;
        //获取消息
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[y] Received '"+message+" '");
            count++;
            //休眠
            Thread.sleep(10);
//            // 返回确认状态，注释掉表示使用自动确认模式       反馈消息的消息状态
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            System.out.println("count="+count);
        }
    }
}
