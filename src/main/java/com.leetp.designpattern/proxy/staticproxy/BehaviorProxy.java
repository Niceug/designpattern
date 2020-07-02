package com.ltp.test.design.proxy.staticproxy;

import java.util.Calendar;

/**
 * @Description 代理类
 * @Author litianpeng
 * @Date 2020/5/16
 */
public class BehaviorProxy implements Behavior {
    private Behavior behavior;

    public BehaviorProxy(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public void eat(String food) {
        if ("垃圾食品".equals(food)) {
            System.out.println("不能吃");
            return;
        }
        System.out.println("洗手");
        behavior.eat(food);
        System.out.println("刷牙");
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) > 17) {
            System.out.println("该下班了");
            return;
        }
        behavior.work();
    }
}
