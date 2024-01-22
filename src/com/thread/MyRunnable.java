package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 9:52
 * @Created by
 *
 * // 定义一个任务类，实现Runnable接口
 */
public class MyRunnable implements Runnable{

    // 重写runnable的run方法
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0;i<= 100;i++){
            System.out.println(thread.getName()+"线程输出："+i);
        }
    }
}
