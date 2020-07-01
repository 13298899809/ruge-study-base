package template.base;

import org.junit.Test;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TempBaseClient
 * @date 2020.07.01 10:57
 */
public class TempBaseClient {
    @Test
    public void test() {
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
        SoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
