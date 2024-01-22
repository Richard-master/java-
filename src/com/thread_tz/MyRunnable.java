package com.thread_tz;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 15:52
 * @Created by
 */
public class MyRunnable implements Runnable {
    private int count; //记录浏览人次

    @Override
    public void run() {
        // 100次
        for (int i = 0; i < 100; i++) {
            System.out.println("count=====>" + (++count));
        }
    }
}
