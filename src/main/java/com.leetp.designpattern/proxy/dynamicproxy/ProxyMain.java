package com.ltp.test.design.proxy.dynamicproxy;


import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author litianpeng
 * @Date 2020/5/16
 */
public class ProxyMain {
    public static void main(String[] args) {
        Behavior behavior = new BehaviorImpl();
        System.out.println("真实类" + behavior);
        DynamicProxy dynamicProxy = new DynamicProxy(behavior);
        Behavior object = (Behavior)Proxy.newProxyInstance(behavior.getClass().getClassLoader(), behavior.getClass().getInterfaces(), dynamicProxy);
        object.eat("东西");
        object.work();
    }
}
