package com.thread_tz;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 15:52
 * @Created by
 */
public class MyRunnable2 implements Runnable {
    // 证书修改的乐观锁，原子类实现。
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        // 100次
        for (int i = 0; i < 100; i++) {
            System.out.println("count=====>" + count.incrementAndGet());
        }
    }
}
