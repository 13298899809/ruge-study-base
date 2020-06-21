package proxy.jdkDynamicProxy;

import org.junit.Test;

public class TestJdkProxy {

    @Test
    public void testJDK7() {
        /**
         * 创建目标对象
         */
        ITeacherDao teacherDao = new TeacherDaoImpl();
        /**
         * 给目标对象创建代理对象 可以转成 ITeacherDao
         */
        ITeacherDao proxyInstance = (ITeacherDao) new JDK7ProxyFactory().getProxyInstance(teacherDao);
        System.out.println("代理对象:" + proxyInstance);
        System.out.println("代理对象class:" + proxyInstance.getClass());
        System.out.println("===================================");
        proxyInstance.teach();
    }

    @Test
    public void testJDK8() {
        /* 创建目标对象 */
        ITeacherDao teacherDao = new TeacherDaoImpl();
        /* 给目标对象创建代理对象 可以转成 ITeacherDao */
        ITeacherDao proxyInstance = (ITeacherDao) new JDK8ProxyFactory().getProxyInstance(teacherDao);
        System.out.println("代理对象:" + proxyInstance);
        System.out.println("代理对象class:" + proxyInstance.getClass());
        System.out.println("===================================");
        proxyInstance.teach();
    }
}
