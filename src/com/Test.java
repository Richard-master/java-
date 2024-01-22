package com;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Test {
    public static void main(String[] args) {
        ProviderConsumerClass providerConsumer = new ProviderConsumerClass();

        // 生产者
        Thread provider = new Thread(()->{
            while(true){
                providerConsumer.put();
            }
        });
        provider.start();

        // 消费者
        Thread customer = new Thread(()->{
            while(true){
                providerConsumer.get();
            }
        });
        customer.start();
    }

}

class ProviderConsumerClass{
    private volatile List<String> list = new ArrayList<>();

    // 生产
    public void put(){
        if(list.isEmpty()){
            list.add("铅笔");
            System.out.println("生产了！！！！");
        }
    }

    // 消费
    public void get(){
        if(!list.isEmpty()){
            list.clear();
            System.out.println("消费了！！！！");
        }
    }
}