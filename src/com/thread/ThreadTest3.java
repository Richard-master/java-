package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 10:07
 * @Created by
 *
 * 掌握线程的创建方式三：实现Callable接口
 */
public class ThreadTest3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个Callable对象
        Callable<String> call = new MyCallable(100);
        // 把callable对象封装成一个futuretask对象

        // 是一个任务对象，实现了runnable接口
        // 可以在线程执行完毕之后，用未来任务对象调用get方法获取线程执行完毕后的结果
        FutureTask<String> f1 = new FutureTask<>(call);

        // 把任务对象交给Thread对象
        new Thread(f1).start();


        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(call2);
        new Thread(f2).start();

        // 如果执行到这，加入上面的线程没有执行完毕。
        // 这里的代码会暂停，等上面的代码执行完毕后才会获取结果
        // 获取线程执行完毕后返回的结果
        String s = f1.get();
        System.out.println(s);


        String s2 = f2.get();
        System.out.println(s2);
    }
}
