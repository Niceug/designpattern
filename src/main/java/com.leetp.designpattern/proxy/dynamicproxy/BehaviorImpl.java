package com.ltp.test.design.proxy.dynamicproxy;

/**
 * @Description 业务类
 * @Author litianpeng
 * @Date 2020/5/16
 */
public class BehaviorImpl implements Behavior {

    @Override
    public void eat(String food) {
        System.out.println("吃" + food);
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println("开始工作");
    }
}
