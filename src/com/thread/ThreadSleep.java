package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 11:19
 * @Created by
 *
 * 掌握sleep方法，join方法的作用
 */
public class ThreadSleep {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0;i<=5;i++){
            System.out.println(i);
            if (i==3){
                //让当前执行的线程暂停5秒，再继续执行
                Thread.sleep(5000);
            }
        }

        //join方法作用：让当前调用这个方法的线程先执行完
        Thread t1 = new MyThread("1号线程");
        t1.start();
        t1.join();

        Thread t2 = new MyThread("2号线程");
        t2.start();
        t2.join();
    }


}
