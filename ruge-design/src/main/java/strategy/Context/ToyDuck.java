package strategy.Context;

import strategy.ConcreteStrategy.NoFlyBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 玩具鸭
 * @date 2020/6/7 13:19
 */
public class ToyDuck extends Duck {
    /**
     * 构造方法给飞行策略进行赋值
     */
    public ToyDuck() {
        flyBehavior = new NoFlyBehavior();
    }

    /**
     * 鸭子的外观
     */
    @Override
    public void display() {
        System.out.println("玩具鸭");
    }

    /**
     * 鸭子叫的能力
     */
    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    /**
     * 鸭子的游泳能力
     */
    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }
}
