package com.wangp.myrabbitmq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.wangp.myrabbitmq.util.ConnectionUtil;

/**
 * @author  farling
 */
public class B_Work_Receiver {
    private final static  String QUEUE_NAME = "queue_work";
 
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false,false, false,null);
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        //关于手工确认 待之后有时间研究下
        channel.basicConsume(QUEUE_NAME, false, consumer);
 
        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received1 '"+message+"'");
            Thread.sleep(10);
            //返回确认状态
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
 
    }
}