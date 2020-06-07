package strategy.Context;

import strategy.ConcreteStrategy.BadFlyBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 北京鸭子
 * @date 2020/6/7 13:16
 */
public class PekingDuck extends Duck {
    /**
     * 鸭子的外观
     */
    @Override
    public void display() {
        System.out.println("~~北京鸭~~~");
    }

    /**
     * 在构造方法里面对飞翔策略进行赋值
     * 假如北京鸭可以飞翔，但是飞翔技术一般
     */
    public PekingDuck() {
        flyBehavior = new BadFlyBehavior();
    }
}
