package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 9:40
 * @Created by
 *
 * 掌握线程的创建方式一：继承Thread类
 */
public class ThreadTest {
    public static void main(String[] args) {
        //创建线程
        Thread t = new MyThread();
        //启动线程
        t.start();
        for (int i = 0;i<= 100;i++){
            System.out.println("Main线程输出："+i);
        }
    }
}
