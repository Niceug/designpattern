package com.ltp.test.design.builder;

/**
 * @Description
 * @Author litianpeng
 * @Date 2020/6/19
 */
public class BuilderTest {
    public static void main(String[] args) {
        Staff tom = Staff.builder().userId(123).userName("tom").cityId(12).build();
        System.out.println(tom);
    }
}
