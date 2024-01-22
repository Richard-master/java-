package com.thread_test;

import java.util.List;
import java.util.Random;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 16:15
 * @Created by
 */
public class SendThread extends Thread {
    private List<String> gift;
    private int count;

    public SendThread(List<String> gift, String name) {
        super(name);
        this.gift = gift;
    }

    @Override
    public void run() {
        //发礼物出去
        // 实现线程安全问题。
        Random r = new Random();
        while (true) {
            synchronized (gift) {
                if (gift.size() < 10) {
                    break;
                }
                String rs = gift.remove(r.nextInt(gift.size()));
                System.out.println(Thread.currentThread().getName() + "发出了" + rs);
                count++;
            }
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
