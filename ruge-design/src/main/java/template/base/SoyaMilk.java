package template.base;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName SoyaMilk 豆浆
 * @date 2020.07.01 10:19
 */
public abstract class SoyaMilk {

    //模板方法
    public final void make() {
        select();
        if (wantAddCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    // 选材料
    public void select() {
        System.out.println("temp 1 豆浆选材~");
    }

    // 添加不同的配料 子类去实现
    public abstract void addCondiments();

    // 浸泡
    public void soak() {
        System.out.println("temp 3 黄豆和配料开始浸泡~");
    }

    public void beat() {
        System.out.println("temp 4 黄豆和配料放到豆浆机中打碎~");
    }

    //钩子方法，决定是否添加配料
    public boolean wantAddCondiments() {
        return true;
    }
}
