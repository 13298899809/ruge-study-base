package strategy.Context;

import strategy.ConcreteStrategy.GoodFlyBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 野鸭
 * @date 2020/6/7 13:18
 */
public class WildDuck extends Duck {
    /**
     * 构造方法中对飞行策略进行赋值
     */
    public  WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    /**
     * 鸭子的外观
     */
    @Override
    public void display() {
        System.out.println(" 这是野鸭 ");
    }
}
