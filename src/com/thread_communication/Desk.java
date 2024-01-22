package com.thread_communication;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname
 * @Description
 * @Date 2023/9/14 12:39
 * @Created by
 */
public class Desk {
    
    private List<String> list = new ArrayList<>();

    // 放1个包子
    // 厨师1  厨师2  厨师3
    public synchronized void put() {
        try {
            String name = Thread.currentThread().getName();
            //判断是否有包子
            if (list.isEmpty()){
                list.add(name+"做的肉包子");
                System.out.println(name+"做了一个肉包子");
                Thread.sleep(2000);

                //等待自己，唤醒别人
                this.notifyAll();
                this.wait();
            }else{
                //有包子了，不做了。
                //唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 吃货1  吃货2
    public synchronized void get() {
        try {
            String name = Thread.currentThread().getName();
            if (!list.isEmpty()){
                // 有包子，吃了
                System.out.println(name+"吃了："+list.get(0));
                list.clear();
                Thread.sleep(1000);
                this.notifyAll();
                this.wait();
            }else{
                //没有包子，不做了。
                //唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
