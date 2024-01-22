package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 9:52
 * @Created by
 *
 * 掌握多线程创建方式二： 实现Runnable接口。
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        // 创建任务对象
        Runnable target = new MyRunnable();
        // 把任务对象交给线程对象处理
        new Thread(target).start();

        for (int i = 0;i<= 100;i++){
            System.out.println("主线程输出："+i);
        }
    }
}
