package proxy.staticProxy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TeacherDaoProxy implements ITeacherDao {
    /**
     *  目标对象 通过接口聚合
     */
    private ITeacherDao iTeacherDao;

    @Override
    public void teach() {
        System.out.println("代理开始...");
        iTeacherDao.teach();
        System.out.println("提交...");
    }
}
