package strategy.ConcreteStrategy;

import strategy.Strategy.FlyBehavior;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 飞翔技术高超
 * @date 2020/6/7 13:09
 */
public class GoodFlyBehavior implements FlyBehavior {
    /**
     * 鸭子的飞翔行为
     */
    @Override
    public void fly() {
        System.out.println(" 飞翔技术高超 ~~~");
    }
}
