package com.thread;

import java.util.concurrent.Callable;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 10:09
 * @Created by
 *
 *
 * 让这个类实现Callable接口
 */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    // 重写call方法
    @Override
    public String call() throws Exception {
        // 描述线程的任务，返回线程执行完毕后的结果
        int sum = 0;
        // 需求：求1~n的和返回
        for (int i = 0;i <=n;i++){
            sum += i;
        }
        return "线程结果是："+sum;
    }
}
