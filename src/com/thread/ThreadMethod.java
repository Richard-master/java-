package com.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 11:14
 * @Created by
 */
public class ThreadMethod {
    public static void main(String[] args) {
        Thread thread = new MyThread("1号线程");
        thread.start();

        Runnable able = new MyRunnable();

        Thread thread1 = new Thread(able);
        thread1.setName("2号线程");
        thread1.start();
    }
}
