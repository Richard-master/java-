package com.thread_pool;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 14:24
 * @Created by
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行");
    }
}
