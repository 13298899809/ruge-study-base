package proxy.staticProxy;

public class StaticProxyClient {
    public static void main(String[] args) {
        /* 1 创建目标对象 */
        TeacherDao teacherDao = new TeacherDao();
        /* 2 创建代理对象 同事将被代理对象 传递给代理对象 */
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        /* 3 通过代理对象  调用被代理对象的方法 */
        teacherDaoProxy.teach();
    }
}
