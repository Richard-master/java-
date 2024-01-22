package com.thread_safe;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 11:28
 * @Created by
 */
public class DrawThread extends Thread{

    private Account acc;

    public DrawThread(Account acc,String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run(){
        acc.drawMoney(100000);
    }
}
