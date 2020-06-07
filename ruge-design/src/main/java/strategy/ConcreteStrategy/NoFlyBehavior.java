package strategy.ConcreteStrategy;

import strategy.Strategy.FlyBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 不会飞翔
 * @date 2020/6/7 13:10
 */
public class NoFlyBehavior implements FlyBehavior {
    /**
     * 鸭子的飞翔行为
     */
    @Override
    public void fly() {
        System.out.println(" 不会飞翔  ");
    }
}
