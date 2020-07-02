package com.leetp.designpattern.chain;

/**
 * @Description 装饰
 * @Author litianpeng
 * @Date 2020/5/15
 */
public class ChainRunTest {

    public interface ChainInterface {
        Integer intercept(Integer price);
    }

    public static class Staff implements ChainInterface {

        private ChainInterface chainInterface = new Manager();

        @Override
        public Integer intercept(Integer price) {
            if (price < 5000) {
                System.out.println("员工可以审批");
                return price * 3;
            }
            return chainInterface.intercept(price);
        }
    }

    public static class Manager implements ChainInterface {
        private ChainInterface chainInterface = new Boss();

        @Override
        public Integer intercept(Integer price) {
            if (price > 5000 && price < 100000) {
                System.out.println("主管可以审批");
                return price * 5;
            }
            return chainInterface.intercept(price);
        }
    }

    public static class Boss implements ChainInterface {

        private ChainInterface chainInterface = null;

        @Override
        public Integer intercept(Integer price) {
            System.out.println("只有老大可以审批");
            return price * 10;
        }
    }

    public static void main(String[] args) {
        ChainInterface chainInterface = new Staff();
        chainInterface.intercept(10000);
    }
}
