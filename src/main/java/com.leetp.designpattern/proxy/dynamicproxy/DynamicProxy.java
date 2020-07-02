package com.leetp.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author litianpeng
 * @Date 2020/5/16
 */
public class DynamicProxy implements InvocationHandler {

    private Behavior behavior;

    public DynamicProxy(Behavior behavior) {
        this.behavior = behavior;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("做一些通用的事情，因为代理类其实是放通用的非业务逻辑的，前面静态代理其实是不太正规的用法");
        long start = System.currentTimeMillis();
        Object ret = method.invoke(behavior, args);
        System.out.println("方法调用时间为" + (System.currentTimeMillis() - start));
        return ret;
    }
}
