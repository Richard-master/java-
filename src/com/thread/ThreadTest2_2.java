package com.thread;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 10:01
 * @Created by
 */
public class ThreadTest2_2 {

    public static void main(String[] args) {
        // 直接创建Runnable接口的匿名内部类形式（任务对象）

        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<= 100;i++){
                    System.out.println("子线程1输出："+i);
                }
            }
        };
        new Thread(target).start();


        //简化形式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<= 100;i++){
                    System.out.println("子线程2输出："+i);
                }
            }
        }).start();


        //再简化
        new Thread(()-> {
                for (int i = 0;i<= 100;i++){
                    System.out.println("子线程3输出："+i);
                }
            }).start();


        for (int i = 0;i<= 100;i++){
            System.out.println("主线程输出："+i);
        }
    }
}
