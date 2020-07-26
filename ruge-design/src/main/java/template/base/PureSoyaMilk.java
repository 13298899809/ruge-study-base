package template.base;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName PureSoyaMilk 纯豆浆
 * @date 2020.07.01 13:36
 */
public class PureSoyaMilk extends SoyaMilk {
    @Override
    public void addCondiments() {

    }

    @Override
    public boolean wantAddCondiments() {
        return false;
    }
}
