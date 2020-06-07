package strategy.Context;

import strategy.Strategy.FlyBehavior;
import strategy.Strategy.QuackBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 鸭子的基类
 * @date 2020/6/7 13:12
 */
public abstract class Duck {
    /**
     * 飞翔的策略接口
     */
    FlyBehavior flyBehavior;
    /**
     * 叫的策略接口
     */
    QuackBehavior quackBehavior;

    public Duck() {
    }

    /**
     * 鸭子的外观
     */
    public abstract void display();

    /**
     * 鸭子叫的能力
     */
    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }

    /**
     * 鸭子的游泳能力
     */
    public void swim() {
        System.out.println("鸭子会游泳~~");
    }

    /**
     * 鸭子的飞翔能力
     */
    public void fly() {

        //改进
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
