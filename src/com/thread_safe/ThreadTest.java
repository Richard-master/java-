package com.thread_safe;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 11:26
 * @Created by
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个账户对象，代表两个的共享账户
        Account acc = new Account("ICBC-110",100000);
        // 2. 创建两个线程，分别代表小红和小明，再去同一个账户中取钱10万。

        // 小明
        Thread t1 = new DrawThread(acc,"小明");
        t1.start();

        //小红
        Thread t2 = new DrawThread(acc,"小红");
        t2.start();
    }
}
