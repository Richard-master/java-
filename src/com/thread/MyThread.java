package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 9:44
 * @Created by
 *
 * 1.让子类继承Thread线程类
 */
public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(String s) {
        super(s);
    }

    @Override
    public void run(){
        //描述线程的执行任务
        Thread thread = Thread.currentThread();
        for (int i = 0;i<= 100;i++){
            System.out.println(thread.getName()+"线程输出："+i);
        }
    }
}
