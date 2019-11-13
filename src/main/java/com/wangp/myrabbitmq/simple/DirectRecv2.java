package com.wangp.myrabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.wangp.myrabbitmq.util.ConnectionUtil;

public class DirectRecv2 {
    private final static String QUEUE_NAME = "test_queue_direct_2";
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //绑定到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"insert");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"update");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,"delete");
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        //定义消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列 false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME, false, consumer);

        //获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[direct] Received '" + message + " '");
            //休眠
            Thread.sleep(10);
            //返回确认状态，注释掉表示使用自动确认模式       反馈消息的消息状态
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
