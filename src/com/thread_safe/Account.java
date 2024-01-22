package com.thread_safe;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 11:26
 * @Created by
 */
public class Account {
    private String cardId;  //卡号
    private double money;   //余额

    //锁对象
    private static final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    // 静态方法用类名.class作为锁
    public static void test() {
        synchronized (Account.class) {

        }
    }

    /***
     * 方式一：同步代码块
     */
    // 小明，小红同时来取钱
//    public void drawMoney(int money) {
//        // 搞清楚是谁来取钱
//        String name = Thread.currentThread().getName();
//        // this带表共享资源
//        // 1.判断余额是否足够
//        synchronized(this) {
//            if (this.money >= money){
//                System.out.println(name+"来取钱，"+money+"成功");
//                this.money -= money;
//                System.out.println(name+"来取钱，剩余余额："+this.money);
//            }else{
//                System.out.println(name+"来取钱，余额不足！");
//            }
//        }
//    }

    /**
     * 方式二：同步方法
     */
    // 小明，小红同时来取钱
//    public synchronized void drawMoney(int money) {
//        // 搞清楚是谁来取钱
//        String name = Thread.currentThread().getName();
//        // this带表共享资源
//        // 1.判断余额是否足够
//        if (this.money >= money) {
//            System.out.println(name + "来取钱，" + money + "成功");
//            this.money -= money;
//            System.out.println(name + "来取钱，剩余余额：" + this.money);
//        } else {
//            System.out.println(name + "来取钱，余额不足！");
//        }
//    }


    /**
     * 方式三：lock锁
     *
     * @param money
     */
    public void drawMoney(int money) {
        // 搞清楚是谁来取钱
        String name = Thread.currentThread().getName();
        //加锁
        lock.lock();
        // this带表共享资源
        // 1.判断余额是否足够
        try {
            if (this.money >= money) {
                System.out.println(name + "来取钱，" + money + "成功");
                this.money -= money;
                System.out.println(name + "来取钱，剩余余额：" + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
