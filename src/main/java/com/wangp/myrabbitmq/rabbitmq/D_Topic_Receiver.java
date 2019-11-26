package com.wangp.myrabbitmq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.wangp.myrabbitmq.util.ConnectionUtil;

import java.io.IOException;
 
/**
 * Created by apple on 2018/9/4.
 */
public class D_Topic_Receiver {
    private final static String QUEUE_NAME = "queue_topic";
    private final static String EXCHANGE_NAME = "exchange_topic";
    private final static String EXCHANGE_TYPE = "topic";
 
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
 
        channel.queueDeclare(QUEUE_NAME, false, false,false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key.*");
 
        channel.basicQos(1);
 
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);
 
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received1 '"+message + "'");
            Thread.sleep(10);
 
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}