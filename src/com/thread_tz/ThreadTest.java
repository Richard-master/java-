package com.thread_tz;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 15:50
 * @Created by
 */
public class ThreadTest {

    public static void main(String[] args) {
        // 目标： 拓展悲观锁，乐观锁原理
        // 悲观锁：一上来就加锁，没有安全感。每次只能一个线程进入访问完毕后再解锁。线程安全，性能较差。
        // 乐观锁：一开始不上锁，认为是没有问题的，大家一起跑，等要出现线程安全问题的时候才开始控制。线程安全，性能较好。

        // 需求：1个静态变量，100个线程，每个线程对其+100次。
        Runnable target = new MyRunnable();

        for (int i = 0;i<100;i++){
            new Thread(target).start();
        }
    }
}
