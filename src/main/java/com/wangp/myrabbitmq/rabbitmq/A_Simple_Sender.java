package com.wangp.myrabbitmq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wangp.myrabbitmq.util.ConnectionUtil;

import java.io.IOException;

/**
 * @Author farling
 * @Date 2019/11/25
 * <p>
 * <p>
 * 重写java操作rabbitmq
 * 字母排序
 *
 * simple包下晦涩难懂已废弃
 */
public class A_Simple_Sender {
    private final static String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws Exception {
        //创建连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明队列
        /**
         *  队列名
         *  是否持久化
         *  是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景
         *  是否自动删除  消费完删除
         *  其他属性
         *
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //消息内容
        /**
         * 交换机
         * 队列名
         * 其他属性  路由
         * 消息body
         */
            Thread.sleep(500);
            String message = "错的不是我，是这个世界~";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[x]Sent '" + message + "'");

        //最后关闭通关和连接
        channel.close();
        connection.close();
    }
}
