package com.thread_pool;

import java.util.concurrent.*;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 13:39
 * @Created by
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
//        ThreadPoolExecutor(int corePoolSize,
//            int maximumPoolSize,
//            long keepAliveTime,
//            TimeUnit unit,
//            BlockingQueue<Runnable> workQueue,
//            ThreadFactory threadFactory,
//            RejectedExecutionHandler handler)
        //1. 通过ThreadPoolExecutor创建一个对象
        ExecutorService pool = new ThreadPoolExecutor(3,
                5,
                8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Runnable target = new MyRunnable();

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
//
        pool.execute(target);
        pool.execute(target);
//
        pool.execute(target);
        pool.execute(target);

//        pool.shutdown();  //等待线程执行完毕后，再关闭线程池
//        pool.shutdownNow(); //立即关闭线程池，不管任务是否执行完毕
    }
}
