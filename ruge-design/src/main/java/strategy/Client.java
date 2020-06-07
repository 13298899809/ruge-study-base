package strategy;

import strategy.ConcreteStrategy.NoFlyBehavior;
import strategy.Context.PekingDuck;
import strategy.Context.ToyDuck;
import strategy.Context.WildDuck;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 客户端
 * @date 2020/6/7 13:20
 */
public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.display();
        pekingDuck.fly();

        //动态改变某个对象的行为, 北京鸭 不能飞
        pekingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("北京鸭的实际飞翔能力");
        pekingDuck.fly();
    }
}
