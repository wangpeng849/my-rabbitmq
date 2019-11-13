package com.wangp.myrabbitmq.spring;

/**
 * 消费者
 */
public class Foo {
    public void listen(String foo){
        System.out.println("\n消费者："+foo+"\n");
    }
}
