package com.thread_communication;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 12:38
 * @Created by
 */
public class ThreadTest {
    public static void main(String[] args) {

        //需求: 3个生产者线程，负责生产包子，每个线程每次只能生产1个包子放在桌子上
        //     2个消费者线程，负责吃包子，每个人每次只能从桌子上拿吃1个包子
        Desk desk = new Desk();

        // 创建3个线程（3个厨师）
        new Thread(()->{
            while (true) {
                desk.put();
            }
        },"厨师1").start();

        new Thread(()->{
            while (true) {
                desk.put();
            }
        },"厨师2").start();

        new Thread(()->{
            while (true) {
                desk.put();
            }
        },"厨师3").start();

        new Thread(()->{
            while (true) {
                desk.get();
            }
        },"吃货1").start();

        new Thread(()->{
            while (true) {
                desk.get();
            }
        },"吃货2").start();
    }
}
