package proxy.jdkDynamicProxy;

public class TeacherDaoImpl implements ITeacherDao {
    /**
     * 老师在授课
     */
    @Override
    public void teach() {
        System.out.println("动态代理...老师授课ing.........");
    }
}
