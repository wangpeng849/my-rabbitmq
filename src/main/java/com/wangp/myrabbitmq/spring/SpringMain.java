//package com.wangp.myrabbitmq.spring;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
///**
// * 生产者
// */
//public class SpringMain {
//    public static void main(final String... args) throws InterruptedException {
//        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/rabbit-context.xml");
//        //RabbitMQ模板
//        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
//        //发送消息
//        template.convertAndSend("Hello , rabbit !");
//        Thread.sleep(100);
//        ctx.destroy();
//    }
//}
