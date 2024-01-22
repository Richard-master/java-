package com.thread_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 16:11
 * @Created by
 */
public class Demo1 {
    // 目标：有100分礼品，小红、小明两人同时发送，当剩下的礼品小于10份的时候则不再送出。
    // 利用多线程模拟该过程并将线程的名称打印出来，并最后在控制台分别打印小红、小明各自送出多少份礼物
    public static void main(String[] args) {
        List<String> gift = new ArrayList<>();
        String[] names = {"口红","包包","鲜花","剃须刀","皮带","手表"};
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            gift.add(names[r.nextInt(names.length)]+(i+1));
        }
        System.out.println(gift);

        // 定义线程类，创建线程对象
        Thread t1 = new SendThread(gift,"小明");
        t1.start();

        Thread t2 = new SendThread(gift,"小红");

        t2.start();


    }
}
