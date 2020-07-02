package com.ltp.test.design.proxy.staticproxy;

/**
 * @Description
 * @Author litianpeng
 * @Date 2020/5/16
 */
public class ProxyMain {
    public static void main(String[] args) {
        Behavior behavior = new BehaviorProxy(new BehaviorImpl());
        behavior.eat("披萨");
        behavior.work();
    }
}
