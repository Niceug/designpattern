package com.ltp.test.design.state;

import lombok.Data;

/**
 * @Description
 * @Author litianpeng
 * @Date 2020/5/29
 */
public class StateDesignPattern {
    public static void main(String[] args) {
        MarioMachine marioMachine = new MarioMachine();
        marioMachine.eatMushroom();
        marioMachine.eatGrass();
        marioMachine.eatPoisonousMushroom();
    }
}

@Data
class MarioMachine {
    int score;
    private IMario currentState;

    public MarioMachine() {
        currentState = BaseMario.getInstance();
    }


    public void eatMushroom() {
        getCurrentState().eatMushroom(this);
        System.out.println("currentState： " + currentState);
    }

    public void eatGrass() {
        getCurrentState().eatGrass(this);
        System.out.println("currentState： " + currentState);
    }

    public void eatPoisonousMushroom() {
        getCurrentState().eatPoisonousMushroom(this);
        System.out.println("currentState： " + currentState);
    }
}

/**
 * 马里奥的几种行为
 */
interface IMario {

    /**
     * 吃蘑菇
     *
     * @param marioMachine
     */
    void eatMushroom(MarioMachine marioMachine);

    /**
     * 吃草
     *
     * @param marioMachine
     */
    void eatGrass(MarioMachine marioMachine);

    /**
     * 吃毒蘑菇
     *
     * @param marioMachine
     */
    void eatPoisonousMushroom(MarioMachine marioMachine);
}

/**
 * 小马里奥
 */
class SmallMario implements IMario {

    private static final SmallMario smallMario = new SmallMario();

    public static IMario getInstance() {
        return smallMario;
    }

    /**
     * 吃蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatMushroom(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 100);
    }

    /**
     * 吃草
     *
     * @param marioMachine
     */
    @Override
    public void eatGrass(MarioMachine marioMachine) {
        marioMachine.setCurrentState(BaseMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 50);
    }

    /**
     * 吃毒蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatPoisonousMushroom(MarioMachine marioMachine) {
        throw new RuntimeException("游戏结束");
    }
}

/**
 * 刚出生时的马里奥
 */
class BaseMario implements IMario {

    private static final BaseMario baseMario = new BaseMario();

    public static IMario getInstance() {
        return baseMario;
    }

    /**
     * 吃蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatMushroom(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 200);
    }

    /**
     * 吃草
     *
     * @param marioMachine
     */
    @Override
    public void eatGrass(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 100);
    }

    /**
     * 吃毒蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatPoisonousMushroom(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SmallMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() - 100);
    }
}

/**
 * 超级马里奥
 */

class SuperMario implements IMario {

    private static final SuperMario superMario = new SuperMario();

    public static IMario getInstance() {
        return superMario;
    }

    /**
     * 吃蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatMushroom(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 1000);
    }

    /**
     * 吃草
     *
     * @param marioMachine
     */
    @Override
    public void eatGrass(MarioMachine marioMachine) {
        marioMachine.setCurrentState(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 500);
    }

    /**
     * 吃毒蘑菇
     *
     * @param marioMachine
     */
    @Override
    public void eatPoisonousMushroom(MarioMachine marioMachine) {
        marioMachine.setCurrentState(BaseMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() - 500);
    }
}

